package com.example.muziekwinkel.services;

import com.example.muziekwinkel.models.Artist;
import com.example.muziekwinkel.models.Label;
import com.example.muziekwinkel.repositories.ArtistRepository;
import com.example.muziekwinkel.repositories.LabelRepository;
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

    //If artist and label exist, see if artist is already signed with label. If not, sign artist.
    public void signArtistToLabel(Long labelId, String artistName) {
        if (!checkLabelExists(labelId)) {
            System.out.println("Label not found.");
            return;
        }
        if (!checkArtistExists(artistName)) {
            System.out.println("Artist not found.");
            return;
        }
        Label label = labelRepository.findById(labelId).get();
        Artist artist = artistRepository.findArtistByName(artistName);
        if (!label.getCurrentArtists().contains(artist)) {
            label.addArtist(artist);
            artist.setCurrentLabel(label);
            labelRepository.save(label);
            artistRepository.save(artist);
        }
    }

    //If artist and label exist, and label signed artist, remove artist from list.
    public void removeArtistFromLabel(Long labelId, String artistName) {
        if (!checkLabelExists(labelId)) {
            System.out.println("Label not found.");
            return;
        }
        if (!checkArtistExists(artistName)) {
            System.out.println("Artist not found.");
            return;
        }
        Label label = labelRepository.findById(labelId).get();
        Artist artist = artistRepository.findArtistByName(artistName);
        if (label.getCurrentArtists().contains(artistRepository.findArtistByName(artistName))) {
            artist.setCurrentLabel(null);
            labelRepository.save(label);
            artistRepository.save(artist);
            System.out.println(artist.getCurrentLabelName());
        } else {
            System.out.println("Artist not signed.");
        }
    }

    //Reusable method to check whether artist exists.
    public boolean checkArtistExists(String artistName) {
        return artistRepository.findArtistByName(artistName) != null;
    }

    //Reusable method to check whether label exists.
    public boolean checkLabelExists(Long labelId) {
        return labelRepository.existsById(labelId);
    }

    public void deleteLabel(Long labelId) {
        labelRepository.deleteById((labelId));
    }

    public void editLabelName(Long labelId, String newLabelName) {
        if (labelRepository.findById(labelId).isPresent()) {
            Label label = labelRepository.findById(labelId).get();
            label.setName(newLabelName);
            labelRepository.save(label);
        }
    }

    public Label getLabel(String labelName) {
        if (labelRepository.findLabelByName(labelName) != null) {
            return labelRepository.findLabelByName(labelName);
        }
        return null;
    }
}