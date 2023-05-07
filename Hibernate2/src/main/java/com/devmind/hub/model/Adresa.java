package com.devmind.hub.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "adrese_studenti")
@Data
public class Adresa {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=SEQUENCE, generator="CUST_SEQ")
    private Integer id;

    @Column(name = "strada")
    @NotNull(message = "strada should not be null")
    @NotBlank(message = "strada should not be blank")
    private String strada;

    @Column(name = "numar")
    @NotNull(message = "numar should not be null")
    @NotBlank(message = "numar should not be blank")
    private String numar;

    @Column(name = "localitate")
    @NotNull(message = "localitate should not be null")
    @NotBlank(message = "localitate should not be blank")
    private String localitate;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "adresa")
    @JsonBackReference
    private Student student;


}
