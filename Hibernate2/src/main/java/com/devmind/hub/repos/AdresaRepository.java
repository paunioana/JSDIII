package com.devmind.hub.repos;

import com.devmind.hub.model.Adresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Repository
public interface AdresaRepository extends JpaRepository<Adresa, Integer> {
    @Modifying
    void deleteById(Integer id);

    Optional<Adresa> findAllByStradaAndNumarAndLocalitate(String strada, String numar, String localitate);
}
