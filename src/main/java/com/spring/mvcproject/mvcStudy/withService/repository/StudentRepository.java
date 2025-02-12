package com.spring.mvcproject.mvcStudy.withService.repository;

import com.spring.mvcproject.mvcStudy.withService.model.Student;

import java.util.Map;

public interface StudentRepository {

    // 학생 ID로 학생을 조회하는 메서드
    Student findByStudentId(String studentId);

    // 학생을 저장하는 메서드
    void saveStudent(Student student);

    // 학년별 학생 수를 구하는 메서드 추가
    Map<String, Integer> countStudentsByGrade();

}
