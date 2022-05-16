package com.example.muziekwinkel.Services;

import com.example.muziekwinkel.Models.Album;
import com.example.muziekwinkel.Repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAlbums() {
        return albumRepository.findAll();
    }

    public void addNewAlbum(Album newAlbum) {
        albumRepository.save(newAlbum);
    }

    public Album changeAlbumName(Long albumId, String newName) {
        Album album = albumRepository.findById(albumId).get();
        album.setName(newName);
        albumRepository.save(album);
        return album;
    }
}