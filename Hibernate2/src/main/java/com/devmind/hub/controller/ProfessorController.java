package com.devmind.hub.controller;

import com.devmind.hub.model.Materie;
import com.devmind.hub.model.Profesor;
import com.devmind.hub.model.Student;
import com.devmind.hub.repos.MateriiRepository;
import com.devmind.hub.repos.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path="/profesor")
public class ProfessorController {
    private final ProfesorRepository profesorRepository;
    private final MateriiRepository materiiRepository;

    @Autowired
    public ProfessorController(ProfesorRepository profesorRepository, MateriiRepository materiiRepository) {
        this.profesorRepository = profesorRepository;
        this.materiiRepository = materiiRepository;
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Optional<Profesor> getProfesor(@PathVariable(value="id") Integer id){
        return profesorRepository.findById(id);
    }

    @GetMapping(path="/materii/{id}")
    public @ResponseBody List<Materie> getMateriiForProfesorWid(@PathVariable(value="id") Integer id){
    return materiiRepository.findAllByProfesorIdUsingQuery(id);
    }
}
