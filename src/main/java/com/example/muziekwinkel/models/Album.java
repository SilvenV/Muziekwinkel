package com.example.muziekwinkel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    @Id
    @SequenceGenerator(
            name = "album_sequence",
            sequenceName = "album_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "album_sequence"
    )
    Long albumId;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "artistId")
    Artist artist;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "labelId")
    Label label;

    @Column
    String name;
    @Column
    String artistName;
    @Column
    String labelName;

    public Album(String name, Artist artist) {
        this.artist = artist;
        this.label = artist.getCurrentLabel();
        this.name = name;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtistName() {
        return artist.getName();
    }

    public String getLabelName() {
        if (label != null)
            return label.getName();
        else
            return "Independent";
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Album{" +
                "artist=" + artist.getName() +
                ", name='" + name + '\'' +
                ", label=" + label.getName() +
                '}';
    }
}