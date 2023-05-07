package com.devmind.hub.model;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "studenti_to_materii")
@Data
public class StudentiToMaterie {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=SEQUENCE, generator="CUST_SEQ")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_materie")
    private Materie materie;
}