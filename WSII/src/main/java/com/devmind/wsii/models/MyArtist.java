package com.devmind.wsii.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "artists")
@Data
public class MyArtist {
    @Id
    @NotNull(message = "id must be not-null")
    @NotBlank(message = "id must be a non-empty string")
    private String id;

    @Column(name ="artist_name")
    @NotNull(message = "name must be not-null")
    @NotBlank(message = "name must be a non-empty string")
    private String name;

    @Column(name="no_followers")
    private Integer followers;

    @OneToMany(mappedBy = "myArtist")
    @JsonIgnore
    private Set<Album> albums;
}
