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
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final LabelRepository labelRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository, ArtistRepository artistRepository, LabelRepository labelRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.labelRepository = labelRepository;
    }

    public List<Album> getAlbums() {
        return albumRepository.findAll();
    }

    public void addNewAlbum(String newAlbumName, String artistName) {
        if (artistRepository.findArtistByName(artistName) != null) {
            Artist artist = artistRepository.findArtistByName(artistName);
            if (albumRepository.findAlbumByName(newAlbumName) == null) {
                Album album = new Album(newAlbumName, artist);
                albumRepository.save(album);
            }
        }
    }

    public Album changeAlbumName(Long albumId, String newName) {
        Album album = albumRepository.findById(albumId).get();
        album.setName(newName);
        albumRepository.save(album);
        return album;
    }

    public void deleteAlbum(Long albumId) {
        if (albumRepository.existsById(albumId)) {
            albumRepository.deleteById(albumId);
        }
    }
}