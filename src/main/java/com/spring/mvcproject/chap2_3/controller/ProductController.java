

package com.spring.mvcproject.chap2_3.controller;

import com.spring.mvcproject.chap2_3.entity.Product;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductController {

    // 가상의 메모리 상품 저장소
    private Map<Long, Product> productStore = new HashMap<>();

    public ProductController() {
        productStore.put(1L, new Product(1L, "에어컨", 1000000));
        productStore.put(2L, new Product(2L, "세탁기", 1500000));
        productStore.put(3L, new Product(3L, "공기청정기", 200000));
    }

    // 1단계
    // 특정 상품 조회 : GET
//    @GetMapping("/products")
//    public String getProduct(HttpServletRequest req) {
//        String id = req.getParameter("id");
//        String price = req.getParameter("price");
//
//        System.out.println("/products?id=%s  : GET 요청이 들어옴!".formatted(id));
//        System.out.println("id = " + id);
//        System.out.println("price = " + price);
//        return "";
//    }

//    // 2단계
//    @GetMapping("/products")
//    public String getProduct(
////            2-1 단계
////            @RequestParam("id") Long id, // 같은 부분 id 생략 가능
////            @RequestParam("price") int price
//
////            2-2 단계
//            Long id, // 같은 부분 id 생략 가능
//            int price
//
//    ) {
//        System.out.println("/products?id=%s  : GET 요청이 들어옴!".formatted(id));
//        System.out.println("id = " + id);
//        System.out.println("price = " + price);
//        return "";
//    }
//
//}

////    3단계
//    @GetMapping("/products")
//    public String getProduct(
//            Long id,
//            @RequestParam(required = false, defaultValue = "1000") int price // 미입력 시 기본값 설정
//
//
//    ) {
//        System.out.println("/products?id=%s  : GET 요청이 들어옴!".formatted(id));
//        System.out.println("id = " + id);
//        System.out.println("price = " + price);
//        return "";
//    }
//}

    //    4단계 ?id=4 → /4 로 변경
    @GetMapping("/products/{id}")
    // id 자리에 값을 넣을 예쩡
    @ResponseBody
    public Product getProduct(
//            4-1 단계
//            @PathVariable("id") Long id // PathVariable 경로에서 읽겠다
//            4-2 단계 생략
            @PathVariable Long id // PathVariable 경로에서 읽겠다
    ) {
        System.out.println("/products?id=%s  : GET 요청이 들어옴!".formatted(id));
        System.out.println("id = " + id);

        Product product = productStore.get(id);
        return product;
    }
}