package com.example.demo.controller;

import com.example.demo.dataIn.CreateStudentRequest;
import com.example.demo.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
public class StudentController {
    @Resource
    StudentService studentService;

    @PostMapping
    public Map<String, Object> createStudent(@RequestBody CreateStudentRequest request) {
        return studentService.createStudent(request);
    }

    @GetMapping
    public Map<String, Object> getStudents() {
        return studentService.getStudents();
    }

    @PutMapping("/{id}")
    public Map<String, Object> updateStudent(@PathVariable Long id, @RequestBody CreateStudentRequest request) {
        return studentService.updateStudent(id, request);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}
