package com.example.muziekwinkel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Label {
    @Id
    @SequenceGenerator(
            name = "label_sequence",
            sequenceName = "label_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "label_sequence"
    )
    Long labelId;
    String name;
    @JsonIgnore
    @OneToMany(mappedBy = "label")
    List<Album> releasedAlbums;
    @OneToMany(mappedBy = "currentLabel")
    List<Artist> currentArtists;

    public Label() {

    }

    public Label(String name) {
        this.name = name;
    }

    public Long getLabelId() {
        return labelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAlbum(Album newLP) {
        releasedAlbums.add(newLP);
    }

    public List<Album> getReleasedAlbums() {
        return releasedAlbums;
    }

    public List<Artist> getCurrentArtists() {
        return currentArtists;
    }
    public void addArtist(Artist artist){
        currentArtists.add(artist);
    }

    @Override
    public String toString() {
        return "Label{" +
                "name='" + name + '\'' +
                ", releasedAlbums=" + releasedAlbums +
                '}';
    }

    public void removeArtist(Artist artistToRemove) {
        if (currentArtists.contains(artistToRemove)) {
            currentArtists.remove(artistToRemove);
        }
    }
}
