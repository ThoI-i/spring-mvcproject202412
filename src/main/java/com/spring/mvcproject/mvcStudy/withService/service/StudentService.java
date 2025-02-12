package com.spring.mvcproject.mvcStudy.withService.service;

import com.spring.mvcproject.mvcStudy.withService.model.Student;
import com.spring.mvcproject.mvcStudy.withService.repository.StudentRepository;

import java.util.Map;

public class StudentService {
    private final StudentRepository repository;

    // 생성자 주입
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // 학생 저장 기능
    public void saveStudent(Student student) {
        repository.saveStudent(student);
    }

    // 학생 조회 기능
    public Student getStudentInfo(String studentId) {
        return repository.findByStudentId(studentId);
    }

    // 학년별 총 학생 수 조회 기능 추가
    public Map<String, Integer> getTotalStudentsByGrade() {
        return repository.countStudentsByGrade();
    }
}
