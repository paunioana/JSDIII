package com.devmind.hub.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "profesori")
@Data
public class Profesor {
    @Id
    @Column(name = "id")

    private Integer id;

    @Column(name = "nume")
    private String nume;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesor")
    @JsonIgnore
    private Set<Materie> materiiPredate;
}