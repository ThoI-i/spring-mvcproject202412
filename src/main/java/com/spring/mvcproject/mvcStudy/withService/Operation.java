package com.spring.mvcproject.mvcStudy.withService;

import com.spring.mvcproject.mvcStudy.withService.controller.StudentController;
import com.spring.mvcproject.mvcStudy.withService.model.Student;


public class Operation {
    public static void main(String[] args) {
        StudentConfig config = new StudentConfig(); // StudentConfig 클래스의 객체 생성 → 메서드 사용

        // StudentController 메서드 사용을 위해 StudentController 객체 필요
        // Controller 가져오기 (자동으로 Repository 주입됨)
        StudentController controller = config.studentController();// 참조 변수 저장 = 객체를 참조하는 변수

        // 학생 정보 저장1
        Student student = new Student("STU001", "엘리시아", "1학년");
        controller.saveStudentInfo(student);  // 저장
        System.out.println("");
        // 학생 정보 저장2
        controller.saveStudentInfo(new Student("STU002", "키아나", "2학년"));
        controller.saveStudentInfo(new Student("STU003", "브로냐", "3학년"));
        controller.saveStudentInfo(new Student("STU004", "후카", "1학년"));
        controller.saveStudentInfo(new Student("STU005", "테리", "2학년"));


        // 학생 정보 조회1
        controller.getStudentInfo("STU001");  // 조회

        // 학년별 총 학생 수 출력
        controller.printTotalStudentsByGrade();
    }
}