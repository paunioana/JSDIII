package com.devmind.hub.repos;

import com.devmind.hub.model.Materie;
import com.devmind.hub.model.Student;
import com.devmind.hub.model.StudentiToMaterie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface StudentiToMaterieRepository extends JpaRepository<StudentiToMaterie, Integer> {
    @Modifying
    @Query(value = "DELETE FROM studenti_to_materii WHERE studenti_to_materii.id_student = ?1", nativeQuery = true)
    void deleteAllByStudentIdUsingQuery(Integer id);



}
