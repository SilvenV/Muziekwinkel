package com.example.muziekwinkel.Services;

import com.example.muziekwinkel.Models.Artist;
import com.example.muziekwinkel.Repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getArtists() {
        return artistRepository.findAll();
    }

    public void addNewArtist(Artist newArtist) {
        if(artistRepository.findArtistByName(newArtist.getName())==null){
            artistRepository.save(newArtist);
        }
    }

    public void deleteArtist(Long artistId) {
        artistRepository.deleteById(artistId);
    }
}