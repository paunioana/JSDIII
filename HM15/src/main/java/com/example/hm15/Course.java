package com.example.hm15;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonSerializableSchema
public class Course {
    private String courseName;
    private Trainer trainer;
    private boolean online;
    private ArrayList<CourseDay> courseDays;
}
