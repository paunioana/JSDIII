package com.devmind.hub.controller;

import com.devmind.hub.model.Adresa;
import com.devmind.hub.model.Student;
import com.devmind.hub.model.StudentiToMaterie;
import com.devmind.hub.repos.AdresaRepository;
import com.devmind.hub.repos.MateriiRepository;
import com.devmind.hub.repos.StudentRepository;
import com.devmind.hub.repos.StudentiToMaterieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentiToMaterieRepository studentiToMaterieRepository;
    private final MateriiRepository materiiRepository;
    private final StudentRepository studentRepository;
    private final AdresaRepository adresaRepository;

    @Autowired
    public StudentController(StudentiToMaterieRepository studentiToMaterieRepository, MateriiRepository materiiRepository, StudentRepository studentRepository, AdresaRepository adresaRepository) {
        this.studentiToMaterieRepository = studentiToMaterieRepository;
        this.studentRepository = studentRepository;
        this.materiiRepository = materiiRepository;
        this.adresaRepository = adresaRepository;
    }

    @PostMapping("/enroll")
    public StudentiToMaterie addStudentToMaterie(@RequestParam("studentId") Integer studentId, @RequestParam("materieId") Integer materieId){
        StudentiToMaterie entry = new StudentiToMaterie();
        entry.setStudent(studentRepository.findById(studentId).orElseThrow());
        entry.setMaterie(materiiRepository.findById(materieId).orElseThrow());
        studentiToMaterieRepository.save(entry);
        return studentiToMaterieRepository.save(entry);
    }

    @PostMapping
    public ResponseEntity<Object> addStudent(@RequestBody Student student){
       if(studentRepository.findAllByCnp(student.getCnp()).isEmpty()) {
           Adresa adresa = student.getAdresa();
           adresaRepository.save(adresa);
           return new ResponseEntity<>(studentRepository.save(student), HttpStatus.valueOf(200));
       }
       return new ResponseEntity<>("user already exists", HttpStatus.valueOf(300));
    }

    @PutMapping("/{studentId}/adresa")
    public ResponseEntity<Object> updateAdresa(@PathVariable(name="studentId") Integer studentId, @RequestBody Adresa adresa){
        if(studentRepository.findById(studentId).isPresent()){
            Adresa oldAddress = studentRepository.findById(studentId).get().getAdresa();
            oldAddress.setLocalitate(adresa.getLocalitate());
            Adresa repoAddress = adresaRepository.findById(oldAddress.getId()).orElseThrow();
            repoAddress.setNumar(adresa.getNumar());
            repoAddress.setStrada(adresa.getStrada());
            repoAddress.setLocalitate(adresa.getLocalitate());
            adresaRepository.save(repoAddress);
            return new ResponseEntity<>(studentRepository.findById(studentId).get(), HttpStatus.valueOf(201));
        }
        return new ResponseEntity<>("there is no student at this address", HttpStatus.valueOf(300));
    }

    @DeleteMapping("/student/{studentId}")
    //@Transactional
    public ResponseEntity<Object> deleteStudent(@PathVariable(name="studentId") Integer studentId){
        Student student = studentRepository.findById(studentId).orElseThrow();
        studentiToMaterieRepository.deleteAllByStudentIdUsingQuery(studentId);
        studentRepository.deleteById(studentId);
        if(studentRepository.findById(studentId).isEmpty()){
            return new ResponseEntity<>("student with id: " + studentId + " was deleted.", HttpStatus.valueOf(200));
        }
        return new ResponseEntity<>("Deletion process encountered an error.", HttpStatus.valueOf(400));
    }
}
