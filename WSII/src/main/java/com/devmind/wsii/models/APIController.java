package com.devmind.wsii.models;

import com.devmind.wsii.repos.AlbumRepo;
import com.devmind.wsii.repos.MyArtistRepo;
import com.devmind.wsii.repos.TrackRepo;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;

import java.io.IOException;



@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    SpotifyService spotifyService;

    @Autowired
    MyArtistRepo myArtistRepo;

    @Autowired
    TrackRepo trackRepo;

    @Autowired
    AlbumRepo albumRepo;

    @GetMapping("/artist")
    public ResponseEntity<String> getArtist(@RequestParam(value="artistName") String artistName) throws IOException, ParseException, SpotifyWebApiException {
        return  new ResponseEntity<>(spotifyService.getArtist(artistName), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/myArtists")
    public ResponseEntity<Object[]> getMyArtists(){
        return new ResponseEntity<>(myArtistRepo.findAll().stream().toArray(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/songs")
    public ResponseEntity<Object[]> getArtistSongs(@RequestParam(value="artistName") String artistName){
        MyArtist myArtist = myArtistRepo.findByName(artistName).get();
        return new ResponseEntity<>(trackRepo.findAllByMyArtist(myArtist).toArray(), HttpStatusCode.valueOf(200));
    }

    @PutMapping("/AddRatingForSong")
    public ResponseEntity<Track> setRatingForSong(@RequestParam(value="artistName") String artistName, @RequestParam(value="songName") String songName,  @RequestParam(value="myRating") int myRating) {
        return new ResponseEntity<>(spotifyService.setTrackRating(artistName, songName, myRating), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/addArtist")
    public ResponseEntity<String> addArtist(@RequestBody MyArtist artist) throws IOException, ParseException, SpotifyWebApiException {
        //myArtistRepo.save(artist);
        return new ResponseEntity<>(spotifyService.getArtistDataById(artist.getId()), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/addSong")
    public ResponseEntity<Track> addSong(@RequestBody Track track)  {
        spotifyService.addSong(track);
        return new ResponseEntity<>(track, HttpStatusCode.valueOf(200));
    }


    @DeleteMapping("/deleteArtist")
    public ResponseEntity<String> deleteAllArtistData(@RequestParam(value="artistName") String artistName){
        return new ResponseEntity<String>(spotifyService.deleteArtistData(artistName), HttpStatusCode.valueOf(200));
    }


}
