package com.example.muziekwinkel.services;

import com.example.muziekwinkel.models.Album;
import com.example.muziekwinkel.models.Artist;
import com.example.muziekwinkel.models.Label;
import com.example.muziekwinkel.repositories.AlbumRepository;
import com.example.muziekwinkel.repositories.ArtistRepository;
import com.example.muziekwinkel.repositories.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    private final ArtistRepository artistRepository;
    private final LabelRepository labelRepository;
    private final AlbumRepository albumRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository, LabelRepository labelRepository, AlbumRepository albumRepository) {
        this.artistRepository = artistRepository;
        this.labelRepository = labelRepository;
        this.albumRepository = albumRepository;
    }

    public List<Artist> getArtists() {
        return artistRepository.findAll();
    }

    public void addNewArtist(Artist newArtist) {
        if (artistRepository.findArtistByName(newArtist.getName()) == null) {
            artistRepository.save(newArtist);
        }
    }

    public void deleteArtist(Long artistId) {
        artistRepository.deleteById(artistId);
    }

    public void editArtistName(Long artistId, String newName) {
        if (artistRepository.existsById(artistId)) {
            Artist artist = artistRepository.findById(artistId).get();
            artist.setName(newName);
            artistRepository.save(artist);
        }
    }

    //Checks if artist and album exist, then whether artist has already registered album. If not, add album to artist.
    public void editArtistAlbum(Long artistId, String albumName) {
        if (artistRepository.existsById(artistId)) {
            Artist artist = artistRepository.findById(artistId).get();
            if (albumRepository.findAlbumByName(albumName) != null) {
                Album album = albumRepository.findAlbumByName(albumName);
                if (!artist.getReleasedAlbums().contains(album)) {
                    artist.addAlbum(album);
                }
            }
        }
    }
}