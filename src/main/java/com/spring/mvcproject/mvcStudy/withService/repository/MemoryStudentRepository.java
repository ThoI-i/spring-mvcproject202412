package com.spring.mvcproject.mvcStudy.withService.repository;

import com.spring.mvcproject.mvcStudy.withService.model.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public Map<String, Integer> countStudentsByGrade() {
        return studentMap.values().stream()
                .collect(Collectors.groupingBy(Student::getGrade, Collectors.summingInt(s -> 1)));
    }
}
