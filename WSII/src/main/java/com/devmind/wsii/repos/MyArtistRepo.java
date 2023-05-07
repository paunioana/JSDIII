package com.devmind.wsii.repos;

import com.devmind.wsii.models.MyArtist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyArtistRepo extends JpaRepository<MyArtist, String> {

    Optional<MyArtist> findByName(String name);
}
