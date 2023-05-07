package com.devmind.wsii.models;

import com.devmind.wsii.repos.AlbumRepo;
import com.devmind.wsii.repos.MyArtistRepo;
import com.devmind.wsii.repos.TrackRepo;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;


@Service
public class SpotifyService {

//    @Value("${spotify.client.id}")
//    private static String clientId;
//
//    @Value("${spotify.client.secret}")
//    private static String clientSecret;
    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId("bcd1056666d84953b908b9d3ec9f535e")
            .setClientSecret("56f98bd850734f8c949f2e793fe6cddd")
            .setRedirectUri(URI.create("http//localhost:8082"))
            .build();
    private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
            .build();

    public static void clientCredentials_Sync() {
        try {
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            // Set access token for further "spotifyApi" object usage
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());

            System.out.println("Expires in: " + clientCredentials.getExpiresIn());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Autowired
    private AlbumRepo albumRepo;
    @Autowired
    private TrackRepo trackRepo;

    @Autowired
    private MyArtistRepo myArtistRepo;

    private void addNewAlbum(Album album) {
        albumRepo.save(album);
    }

    private void addNewArtist(MyArtist myArtist){
        myArtistRepo.save(myArtist);
    }
    private MyArtist getMyArtist(String artistName) {
        return myArtistRepo.findByName(artistName).get();

    }
    @Transactional
    String deleteArtistData(String artistName){
        MyArtist myArtist = getMyArtist(artistName);
        int no_tracks = trackRepo.deleteAllByMyArtist(myArtist).size();
        int no_albums = albumRepo.deleteAllByMyArtist(myArtist).size();
        myArtistRepo.delete(myArtist);
        return "Deleted "+ no_albums + " albums and " + no_tracks + " tracks.";

    }

    Track setTrackRating(String artistName, String trackName, int myRating){
        MyArtist myArtist = getMyArtist(artistName);
        Optional<Track> myTrack = trackRepo.findTrackByNameAndMyArtist(trackName, myArtist);
        if (myTrack.isPresent()) {
            myTrack.get().setMyRating(myRating);
            trackRepo.save(myTrack.get());
        }
        return myTrack.orElseThrow();
    }

    void addSong(Track track){
        trackRepo.save(track);
    }

    private void addNewTrack(Track track) {
        trackRepo.save(track);
    }

    String getArtist(String artistName) throws IOException, ParseException, SpotifyWebApiException {
        clientCredentials_Sync();
        System.out.println(spotifyApi.getAccessToken());

        Artist[] artists = spotifyApi.searchArtists(artistName).build().execute().getItems();
        if(myArtistRepo.findById(artists[0].getName()).isEmpty()) {
            MyArtist myArtist = new MyArtist();
            myArtist.setId(artists[0].getId());
            myArtist.setName(artists[0].getName());
            myArtist.setFollowers(artists[0].getFollowers().getTotal());
            addNewArtist(myArtist);
            AlbumSimplified[] albums = spotifyApi.getArtistsAlbums(artists[0].getId()).build().execute().getItems();
            for (int i = 0; i < albums.length; i++) {
                Album item = new Album();
                item.setName(albums[i].getName());
                item.setReleaseDate(albums[i].getReleaseDate());
                item.setMyArtist(myArtist);
                addNewAlbum(item);
                TrackSimplified[] tracks = spotifyApi.getAlbumsTracks(albums[i].getId()).build().execute().getItems();
                for (int j = 0; j < tracks.length; j++) {
                    Track track = new Track();
                    track.setName(tracks[j].getName());
                    track.setAlbum(item);
                    track.setMyArtist(myArtist);
                    track.setDurationMs(tracks[j].getDurationMs());
                    addNewTrack(track);
                }
            }
            return "data for artist " + artistName + " added";
        }
        return "artist data already added";
    }

    String getArtistDataById(String id) throws IOException, ParseException, SpotifyWebApiException {
        clientCredentials_Sync();
        Artist spotArtist = spotifyApi.getArtist(id).build().execute();
        if (spotArtist.getId().equals(id)) {
            MyArtist myArtist = new MyArtist();
            myArtist.setId(id);
            if (myArtistRepo.findById(id).isEmpty()) {
                myArtist.setName(spotArtist.getName());
                myArtist.setFollowers(spotArtist.getFollowers().getTotal());
                addNewArtist(myArtist);
                AlbumSimplified[] albums = spotifyApi.getArtistsAlbums(spotArtist.getId()).build().execute().getItems();
                for (int i = 0; i < albums.length; i++) {
                    Album item = new Album();
                    item.setName(albums[i].getName());
                    item.setReleaseDate(albums[i].getReleaseDate());
                    item.setMyArtist(myArtist);
                    addNewAlbum(item);
                    TrackSimplified[] tracks = spotifyApi.getAlbumsTracks(albums[i].getId()).build().execute().getItems();
                    for (int j = 0; j < tracks.length; j++) {
                        Track track = new Track();
                        track.setName(tracks[j].getName());
                        track.setAlbum(item);
                        track.setMyArtist(myArtist);
                        track.setDurationMs(tracks[j].getDurationMs());
                        addNewTrack(track);
                    }
                }
                return "data for artist " + spotArtist.getName() + " added";
            } else {
                return "artist data already added";
            }
        }
        return "artist with id:" + id + "not found in spotify";
    }
}
