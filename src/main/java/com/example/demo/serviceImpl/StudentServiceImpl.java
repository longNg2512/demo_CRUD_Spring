package com.example.demo.serviceImpl;

import com.example.demo.dataIn.CreateStudentRequest;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentRepository studentRepository;

    private Map<String, Object> setupResponse(Boolean success, String message, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        response.put("message", message);
        response.put("data", data);
        return response;
    }

    @Override
    public Map<String, Object> createStudent(CreateStudentRequest request) {
        try {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setName(request.getName());
            studentEntity.setAge(request.getAge());
            studentEntity.setClasses(request.getClasses());
            StudentEntity student = studentRepository.save(studentEntity);
            return setupResponse(true, "Create student successfully!", student);
        } catch (Exception error) {
            return setupResponse(false, error.getMessage(), null);
        }
    }

    @Override
    public Map<String, Object> getStudents() {
        try {
            List<StudentEntity> students = studentRepository.findAll();
            return setupResponse(true, "Get students successfully!", students);

        } catch (Exception error) {
            return setupResponse(false, error.getMessage(), null);
        }
    }

    @Override
    public Map<String, Object> updateStudent(Long id, CreateStudentRequest request) {
        try {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setId(id);
            studentEntity.setName(request.getName());
            studentEntity.setAge(request.getAge());
            studentEntity.setClasses(request.getClasses());
            StudentEntity student = studentRepository.save(studentEntity);
            return setupResponse(true, "Update student successfully!", student);
        } catch (Exception error) {
            return setupResponse(false, error.getMessage(), null);
        }
    }

    @Override
    public Map<String, Object> deleteStudent(Long id) {
        try {
            StudentEntity student = studentRepository.findById(id).get();
            studentRepository.deleteById(id);
            return setupResponse(true, "Delete student successfully!", student);
        } catch (Exception error) {
            return setupResponse(false, error.getMessage(), null);
        }
    }

}
