package com.example.muziekwinkel.controllers;

import com.example.muziekwinkel.models.Artist;
import com.example.muziekwinkel.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v3/artists")
public class ArtistController {
    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping(path = "showall")
    public List<Artist> getArtists() {
        return artistService.getArtists();
    }
    @GetMapping(path="showartist")
    public Artist getArtist(@RequestParam String artistName){
        return artistService.getArtist(artistName);
    }

    @PostMapping(path = "admin/newartist")
    public void newArtist(@RequestBody Artist artist) {
        artistService.addNewArtist(artist);
    }

    @DeleteMapping(path = "admin/deleteartist")
    public void deleteArtist(@RequestParam Long artistId) {
        artistService.deleteArtist(artistId);
    }

    @PutMapping(path = "admin/editartistname")
    public void editArtistName(@RequestParam Long artistId, String newName) {
        artistService.editArtistName(artistId, newName);
    }

    @PutMapping(path="admin/editartistalbum")
    public void editArtistAlbum(@RequestParam Long artistId, String albumName){
        artistService.editArtistAlbum(artistId, albumName);
    }
}