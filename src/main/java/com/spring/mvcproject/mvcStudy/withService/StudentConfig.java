package com.spring.mvcproject.mvcStudy.withService;

import com.spring.mvcproject.mvcStudy.withService.controller.StudentController;
import com.spring.mvcproject.mvcStudy.withService.repository.MemoryStudentRepository;
import com.spring.mvcproject.mvcStudy.withService.repository.StudentRepository;
import com.spring.mvcproject.mvcStudy.withService.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    // StudentRepository 빈 등록
    @Bean
    public StudentRepository studentRepository() {
        return new MemoryStudentRepository();
    }

    // StudentService 빈 등록
    @Bean
    public StudentService studentService() {
        return new StudentService(studentRepository()); // Repository 주입
    }

    // StudentController 빈 등록 (Service를 주입)
    @Bean
    public StudentController studentController() {
        return new StudentController(studentService()); // Repository가 아니라 Service를 주입!
    }
}
