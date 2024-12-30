package com.spring.mvcproject.chap6_3.api;

import com.spring.mvcproject.chap6_3.dto.request.MemberCreateRequest;
import com.spring.mvcproject.chap6_3.entity.Member;
import com.spring.mvcproject.chap6_3.exception.MemberException;
import jakarta.validation.Valid;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v6/members")
@Slf4j
public class MemberApiController {

    private Map<String, Member> memberStore = new HashMap<>();

    public MemberApiController() {
        Member m1 = Member.builder()
                .account("abc1234")
                .password("12345678")
                .nickname("호돌이")
                .build();

        Member m2 = Member.builder()
                .account("def9876")
                .password("12345678")
                .nickname("핑돌이")
                .build();

        memberStore.put(m1.getAccount(), m1);
        memberStore.put(m2.getAccount(), m2);
    }

    // 회원 단일 조회
    @GetMapping("/{account}")
    public ResponseEntity<?> findOne(@PathVariable String account) {

        log.info("회원 단일 조회 요청이 들어옴!");
        log.debug("parameter account : {}", account);

        if (account.length() > 10) {
            log.warn("심각한 오류 발생!!");
//          // 1단계
//            return ResponseEntity
//                    .badRequest()
//                    .body("계정명은 10글자 이내여야 합니다.");
            // 2단계
//            throw new IllegalStateException("계정 명은 10글자 이내여야합니다.");
            // 3단계
            throw new MemberException(HttpStatus.BAD_REQUEST, "계정명은 10글자 이내여야 합니다.");
        }

        Member member = memberStore.get(account);

        if (member == null) {
//          // 1단계
            //            return ResponseEntity
//                    .status(HttpStatus.NOT_FOUND)
//                    .body("회원 계정명을 다시 확인하세요!");
            // 2단계
//            throw new IllegalStateException("회원 계정명을 다시 확인하세요");
//            3단계
            throw new MemberException(HttpStatus.NOT_FOUND, "회원 계정명을 다시 확인하세요!");
        }

        return ResponseEntity.ok().body(member);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid MemberCreateRequest dto) {

        Member member = Member.builder()
                .nickname(dto.getNickname())
                .account(dto.getAccount())
                .password(dto.getPassword())
                .build();

        memberStore.put(member.getAccount(), member);

        return ResponseEntity.ok().body(member);
    }

}
