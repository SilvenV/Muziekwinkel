package com.example.muziekwinkel.Controllers;

import com.example.muziekwinkel.Models.Label;
import com.example.muziekwinkel.Services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v3/labels")
public class LabelController {
    private final LabelService labelService;

    @Autowired
    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @GetMapping(path="showall")
    public List<Label> getLabels(){
        return labelService.getLabels();
    }

    @PostMapping(path="newlabel")
    public void newLabel(@RequestBody Label label){
        labelService.addNewLabel(label);
    }

    @PutMapping(path="signartisttolabel/artistName={artistName}&labelName={labelName}")
    public void signArtistToLabel(@PathVariable("artistName") String artistName, @PathVariable("labelName") String labelName){
        labelService.signArtistToLabel(artistName, labelName);
    }
    @PutMapping(path="removeartistfromlabel")
    public void removeArtist(@RequestParam String artistName, @RequestParam String labelName){
        labelService.removeArtistFromLabel(artistName, labelName);
    }

    @DeleteMapping(path="deletelabel")
    public void deleteLabel(@RequestParam Long labelId){
        labelService.deleteLabel(labelId);
    }
}
