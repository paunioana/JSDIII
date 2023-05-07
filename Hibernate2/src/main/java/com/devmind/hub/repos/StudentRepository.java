package com.devmind.hub.repos;

import com.devmind.hub.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByNume(String nume);

    Optional<Student> findByNumeAndPrenume(String nume, String prenume);

    Optional<Student> findAllByCnp(String cnp);
}
