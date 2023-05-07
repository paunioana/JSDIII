package com.devmind.wsii.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Generated;

import java.util.Set;

@Entity
@Table(name = "albums")
@Data
public class Album {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name ="album_name")
    private String name;
    @Column(name ="release_date")
    private String releaseDate;

    @OneToMany(mappedBy = "album")
    @JsonIgnore
    private Set<Track> tracks;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private MyArtist myArtist;

}
