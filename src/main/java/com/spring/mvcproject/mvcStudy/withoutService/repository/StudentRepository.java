package com.spring.mvcproject.mvcStudy.withoutService.repository;

import com.spring.mvcproject.mvcStudy.withoutService.model.Student;

public interface StudentRepository {

    // 학생 ID로 학생을 조회하는 메서드
    Student findByStudentId(String studentId);

    // 학생을 저장하는 메서드
    void saveStudent(Student student);
}
