package com.spring.mvcproject.mvcStudy.withoutService.repository;

import com.spring.mvcproject.mvcStudy.withoutService.model.Student;

import java.util.HashMap;
import java.util.Map;

public class MemoryStudentRepository implements StudentRepository {

    private Map<String, Student> studentMap = new HashMap<>();

    @Override
    public Student findByStudentId(String studentId) {
        return studentMap.get(studentId);
    }

    @Override
    public void saveStudent(Student student) {
        studentMap.put(student.getStudentId(), student);
    }
}
