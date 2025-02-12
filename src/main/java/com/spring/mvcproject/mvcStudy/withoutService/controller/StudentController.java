package com.spring.mvcproject.mvcStudy.withoutService.controller;

import com.spring.mvcproject.mvcStudy.withoutService.model.Student;
import com.spring.mvcproject.mvcStudy.withoutService.repository.StudentRepository;

public class StudentController {

    private final StudentRepository repository;

    // 생성자 주입
    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    // 학생 정보 출력 메서드
    public void getStudentInfo(String studentId) {
        Student student = repository.findByStudentId(studentId);
        if (student != null) {
            System.out.println("학생 정보: " + student);
        } else {
            System.out.println("학생 정보를 찾을 수 없습니다.");
        }
    }
    // 학생 정보 저장 메서드
    public void saveStudentInfo(Student student) {
        repository.saveStudent(student);
        System.out.println("학생 정보가 저장되었습니다: " + student);
    }
}
