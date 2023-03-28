package com.example.demo.dataIn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateStudentRequest {
    private String name;
    private Integer age;
    private String classes;
}
