package com.example.muziekwinkel.Services;

import com.example.muziekwinkel.Models.Artist;
import com.example.muziekwinkel.Models.Label;
import com.example.muziekwinkel.Repositories.ArtistRepository;
import com.example.muziekwinkel.Repositories.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelService {
    private final LabelRepository labelRepository;
    private final ArtistRepository artistRepository;

    @Autowired
    public LabelService(LabelRepository labelRepository, ArtistRepository artistRepository) {
        this.labelRepository = labelRepository;
        this.artistRepository = artistRepository;
    }

    public List<Label> getLabels() {
        return labelRepository.findAll();
    }

    public void addNewLabel(Label newLabel) {
        if (labelRepository.findLabelByName(newLabel.getName()) == null) {
            labelRepository.save(newLabel);
        }
    }

    public void removeLabel(Long labelId) {
        labelRepository.deleteById(labelId);
    }

    public void addArtistToLabel(Artist artist, Label label) {
        if (labelRepository.findById((long) label.getLabelId()).isPresent()) {
            if (label.getCurrentArtists().contains(artist)) {
                System.out.println("Artist is already signed.");
            } else {
                label.addArtist(artist);
            }
        } else {
            System.out.println("Label not found.");
        }
    }

    //If artist and label exist, see if artist is already signed with label. If not, sign artist.
    public void signArtistToLabel(String artistName, String labelName) {
        if (!checkLabelExists(labelName)) {
            System.out.println("Label not found.");
            return;
        }
        if (!checkArtistExists(artistName)) {
            System.out.println("Artist not found.");
            return;
        }
        Label label = labelRepository.findLabelByName(labelName);
        Artist artist = artistRepository.findArtistByName(artistName);
        if (!label.getCurrentArtists().contains(artist)) {
            label.addArtist(artist);
            artist.setCurrentLabel(label);
            labelRepository.save(label);
            artistRepository.save(artist);
        }
    }

    //If artist and label exist, and label signed artist, remove artist from list.
    public void removeArtistFromLabel(String artistName, String labelName) {
        if (!checkLabelExists(labelName)) {
            System.out.println("Label not found.");
            return;
        }
        if (!checkArtistExists(artistName)) {
            System.out.println("Artist not found.");
            return;
        }
        Label label = labelRepository.findLabelByName(labelName);
        Artist artist = artistRepository.findArtistByName(artistName);
        if (label.getCurrentArtists().contains(artist)) {
            label.removeArtist(artist);
        } else {
            System.out.println("Artist not signed.");
        }
    }

    //Reusable method to check whether artist exists.
    public boolean checkArtistExists(String artistName) {
        return artistRepository.findArtistByName(artistName) != null;
    }

    //Reusable method to check whether label exists.
    public boolean checkLabelExists(String labelName) {
        return labelRepository.findLabelByName(labelName) != null;
    }

    public void deleteLabel(Long labelId) {
        labelRepository.deleteById((labelId));
    }
}