package com.spring.mvcproject.mvcStudy.withoutService;

import com.spring.mvcproject.mvcStudy.withoutService.controller.StudentController;
import com.spring.mvcproject.mvcStudy.withoutService.repository.MemoryStudentRepository;
import com.spring.mvcproject.mvcStudy.withoutService.repository.StudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    // StudentRepository 빈 등록
    @Bean
    public StudentRepository studentRepository() {
        return new MemoryStudentRepository();
    }

    // StudentController 빈 등록
    @Bean
    public StudentController studentController() {
        return new StudentController(studentRepository());
        // 생성자를 통해 의존성 주입
    }
}

