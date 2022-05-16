package com.example.muziekwinkel.Controllers;

import com.example.muziekwinkel.Models.Album;
import com.example.muziekwinkel.Services.AlbumService;
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

    @PostMapping(path = "add")
    public void addNewLP(@RequestBody Album album) {
        albumService.addNewAlbum(album);
    }

    @GetMapping(path = "showall")
    public List<Album> getLPs() {
        return albumService.getAlbums();
    }

    @PutMapping(path="changealbumname")
    public Album changeAlbumName(@RequestParam Long albumId, String newName){
        return albumService.changeAlbumName(albumId, newName);
    }
}
