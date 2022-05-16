package com.example.muziekwinkel.Models;

import javax.persistence.*;

@Entity
@Table
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artistId")
    Artist artist;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "labelId")
    Label label;

    String name;
    String genre;
    String colour;
    int releaseYear;
    int edition;
    String country;
    Boolean hasPictureDisc;
    String shape;

    public Album() {

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Label getLabel() {
        return label;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getCountry() {
        return country;
    }

    public boolean isHasPictureDisc() {
        return hasPictureDisc;
    }

    public void setHasPictureDisc(boolean hasPictureDisc) {
        this.hasPictureDisc = hasPictureDisc;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "Album{" +
                "artist=" + artist +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", label=" + label +
                ", colour='" + colour + '\'' +
                ", releaseYear=" + releaseYear +
                ", edition=" + edition +
                ", country='" + country + '\'' +
                ", hasPictureDisc=" + hasPictureDisc +
                ", shape='" + shape + '\'' +
                '}';
    }
}
