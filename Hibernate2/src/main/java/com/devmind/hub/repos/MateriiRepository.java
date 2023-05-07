package com.devmind.hub.repos;

import com.devmind.hub.model.Materie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface MateriiRepository extends JpaRepository<Materie, Integer> {
    @Query("SELECT s FROM Materie s WHERE s.profesor.id = ?1")
    List<Materie> findAllByProfesorIdUsingQuery(Integer id);
}
