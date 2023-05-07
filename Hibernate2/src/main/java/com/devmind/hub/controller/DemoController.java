package com.devmind.hub.controller;

import com.devmind.hub.model.Student;
import com.devmind.hub.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/demo")
public class DemoController {
    private final StudentRepository studentRepository;

    @Autowired
    public DemoController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping(path="/student/all")
    public @ResponseBody Iterable<Student> getStudents(){
        return studentRepository.findAll();

    }
}
