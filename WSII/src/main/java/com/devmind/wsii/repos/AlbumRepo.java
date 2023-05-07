package com.devmind.wsii.repos;

import com.devmind.wsii.models.Album;
import com.devmind.wsii.models.MyArtist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepo extends JpaRepository<Album, String> {
    List<Optional<Album>> deleteAllByMyArtist(MyArtist artist);

}
