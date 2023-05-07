package com.devmind.hub.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "materii")
@Data
public class Materie {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nume")
    private String nume;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "cursuriAlese", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Student> studentiInrolati;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "materie")
    @JsonIgnore
    private Set<StudentiToMaterie> inscrieri;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @JsonBackReference
    private Profesor profesor;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materie materie = (Materie) o;
        return id.equals(materie.id) && nume.equals(materie.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume);
    }
}
