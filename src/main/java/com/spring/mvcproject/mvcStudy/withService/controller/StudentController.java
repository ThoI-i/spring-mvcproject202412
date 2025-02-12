package com.spring.mvcproject.mvcStudy.withService.controller;

import com.spring.mvcproject.mvcStudy.withService.model.Student;
import com.spring.mvcproject.mvcStudy.withService.repository.StudentRepository;
import com.spring.mvcproject.mvcStudy.withService.service.StudentService;

import java.util.Map;

public class StudentController {
    private final StudentService service;

    // 생성자 주입
    public StudentController(StudentService service) {
        this.service = service;
    }

    public void getStudentInfo(String studentId) {
        Student student = service.getStudentInfo(studentId);
        if (student != null) {
            System.out.println("학생 정보: " + student);
        } else {
            System.out.println("학생 정보를 찾을 수 없습니다.");
        }
    }

    public void saveStudentInfo(Student student) {
        service.saveStudent(student);
        System.out.println("학생 정보가 저장되었습니다: " + student);
    }

    // 👇 학년별 총 학생 수 출력 기능 추가
    public void printTotalStudentsByGrade() {
        Map<String, Integer> totalStudents = service.getTotalStudentsByGrade();
        System.out.println("학년별 총 학생 수:");
        totalStudents.forEach((grade, count) ->
                System.out.println(grade + ": " + count + "명")
        );
    }
}
