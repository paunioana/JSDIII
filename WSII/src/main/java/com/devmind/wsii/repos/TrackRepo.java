package com.devmind.wsii.repos;

import com.devmind.wsii.models.MyArtist;
import com.devmind.wsii.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrackRepo extends JpaRepository<Track, String> {
    List<Optional<Track>> findAllByMyArtist(MyArtist artist);
    List<Optional<Track>> deleteAllByMyArtist(MyArtist artist);

    Optional<Track> findTrackByNameAndMyArtist(String name, MyArtist myArtist);



}
