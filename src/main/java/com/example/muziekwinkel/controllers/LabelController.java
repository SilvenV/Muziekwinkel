package com.example.muziekwinkel.controllers;

import com.example.muziekwinkel.models.Label;
import com.example.muziekwinkel.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v3/labels")
public class LabelController {
    private final LabelService labelService;

    @Autowired
    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @GetMapping(path = "showall")
    public List<Label> getLabels() {
        return labelService.getLabels();
    }
    @GetMapping(path="showlabel")
    public Label getLabel(@RequestParam String labelName){
        return labelService.getLabel(labelName);
    }

    @PostMapping(path = "admin/newlabel")
    public void newLabel(@RequestBody Label label) {
        labelService.addNewLabel(label);
    }

    @DeleteMapping(path = "admin/deletelabel")
    public void deleteLabel(@RequestParam Long labelId) {
        labelService.deleteLabel(labelId);
    }

    @PutMapping(path = "admin/editlabelname")
    public void editLabelName(@RequestParam Long labelId, String newLabelName) {
        labelService.editLabelName(labelId, newLabelName);
    }

    @PutMapping(path = "admin/signartist")
    public void signArtistToLabel(@RequestParam Long labelId, String artistName) {
        labelService.signArtistToLabel(labelId, artistName);
    }

    @PutMapping(path = "admin/removeartist")
    public void removeArtistFromLabel(@RequestParam Long labelId, String artistName) {
        labelService.removeArtistFromLabel(labelId, artistName);
    }
}