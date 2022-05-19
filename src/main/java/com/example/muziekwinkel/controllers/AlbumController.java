package com.example.muziekwinkel.controllers;

import com.example.muziekwinkel.models.Album;
import com.example.muziekwinkel.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v3/albums")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping(path = "showall")
    public List<Album> getAlbums() {
        return albumService.getAlbums();
    }

    @PostMapping(path = "admin/newalbum")
    public void addNewAlbum(@RequestParam String albumName, String artistName, String labelName) {
        albumService.addNewAlbum(albumName, artistName);
    }

    @DeleteMapping(path = "admin/deletealbum")
    public void deleteAlbum(@RequestParam Long albumId) {
        albumService.deleteAlbum(albumId);
    }

    @PutMapping(path = "admin/changealbumname")
    public Album changeAlbumName(@RequestParam Long albumId, String newName) {
        return albumService.changeAlbumName(albumId, newName);
    }
}
