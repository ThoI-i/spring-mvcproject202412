package com.spring.mvcproject.mvcStudy.withoutService.model;

public class Student {

    private String studentId;
    private String name;
    private String grade;

    // 기본 생성자
    public Student() {}

    // 모든 필드를 받는 생성자
    public Student(String studentId, String name, String grade) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
    }

    // Getter와 Setter
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    // equals와 hashCode 메서드
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        return studentId.hashCode();
    }
}
