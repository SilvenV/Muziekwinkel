package com.example.muziekwinkel.Controllers;

import com.example.muziekwinkel.Models.Artist;
import com.example.muziekwinkel.Services.ArtistService;
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

    @PostMapping(path = "newartist")
    public void newArtist(@RequestBody Artist artist) {
        artistService.addNewArtist(artist);
    }

    @DeleteMapping(path = "deleteartist")
    public void deleteArtist(@RequestParam Long artistId) {
        artistService.deleteArtist(artistId);
    }
}
