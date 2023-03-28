package com.example.demo.service;

import com.example.demo.dataIn.CreateStudentRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface StudentService {
    Map<String, Object> createStudent(CreateStudentRequest request) ;

    Map<String, Object> getStudents();

    Map<String, Object> updateStudent(Long id, CreateStudentRequest request);

    Map<String, Object> deleteStudent(Long id);
}
