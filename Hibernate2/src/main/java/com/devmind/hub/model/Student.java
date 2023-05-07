package com.devmind.hub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "studenti")
@Data
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=SEQUENCE, generator="CUST_SEQ")
    private Integer id;

    @Column(name = "nume")
    @NotNull(message = "nume should not be null")
    @NotBlank(message = "nume should not be blank")
    private String nume;

    @Column(name = "prenume")
    @NotNull(message = "prenume should not be null")
    @NotBlank(message = "prenume should not be blank")
    private String prenume;

    @Column(name = "CNP")
    @NotNull(message = "cnp should not be null")
    @NotBlank(message = "cnp should not be blank")
    private String cnp;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JoinTable(
            name = "studenti_to_materii",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_materie"))
//    @ToString.Exclude
    private Set<Materie> cursuriAlese;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    //@ToString.Exclude
    private Set<StudentiToMaterie> inscrieri;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_adresa")
    @NotNull(message = "adresa should not be null")
    @NotBlank(message = "adresa should not be blank")
    //@ToString.Exclude
    private Adresa adresa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id) && nume.equals(student.nume) && prenume.equals(student.prenume) && cnp.equals(student.cnp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume, prenume, cnp);
    }
}