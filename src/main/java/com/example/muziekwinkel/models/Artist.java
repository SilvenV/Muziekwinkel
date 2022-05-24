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
    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    @JoinColumn(name = "labelId")
    Label currentLabel;
    @Column
    String currentLabelName;
    @Column
    @OneToMany(mappedBy = "artist")
    List<Album> releasedAlbums;

    public String getCurrentLabelName() {
        if (currentLabel != null)
            return currentLabel.getName();
        else
            return "Independent";
    }

    public Artist(String name, int yearFounded) {
        this.name = name;
        this.yearFounded = yearFounded;
    }

    public void addAlbum(Album album) {
        releasedAlbums.add(album);
    }
}