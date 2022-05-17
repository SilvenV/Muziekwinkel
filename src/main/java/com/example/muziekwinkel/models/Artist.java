package com.example.muziekwinkel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Artist {
    @Id
    @SequenceGenerator(
            name = "artist_sequence",
            sequenceName = "artist_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "artist_sequence"
    )
    Long artistId;
    @Column
    String name;
    @Column
    int yearFounded;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "labelId")
    Label currentLabel;
    @Column
    @OneToMany(mappedBy = "artist")
    List<Album> releasedAlbums;

    public void setCurrentLabel(Label newLabel) {
        if (currentLabel != null) {
            if (currentLabel != newLabel) {
                currentLabel.removeArtist(this);
                this.currentLabel = newLabel;
            }
        } else {
            this.currentLabel = newLabel;
        }
    }

    public Artist(String name, int yearFounded) {
        this.name = name;
        this.yearFounded = yearFounded;
    }
    public void addAlbum(Album album){
        releasedAlbums.add(album);
    }
}