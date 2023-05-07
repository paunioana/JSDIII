package com.devmind.wsii.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "tracks")
@Data
public class Track {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "track_name")
    @NotNull(message = "track name must be not-null")
    @NotBlank(message = "track name must be a non-empty string")
    private String name;

    @Column(name = "duration_ms")
    private Integer durationMs;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne
    @JoinColumn(name="artist_id")
    @NotNull(message = "artist id must be not-null")
    @NotBlank(message = "artist id must be a non-empty string")
    private MyArtist myArtist;

    @Column(name = "my_rating")
    private int myRating;

}
