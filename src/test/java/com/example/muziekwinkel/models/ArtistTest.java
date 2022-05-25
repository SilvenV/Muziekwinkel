package com.example.muziekwinkel.models;

import com.example.muziekwinkel.repositories.ArtistRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArtistTest {
    Artist artist;
    Label label;
    Album album;
    ArtistRepository mockRepository;

    @Before
    public void setUp() throws Exception {
        artist = new Artist("Archibald Testartist", 2000);
        label = new Label();
    }

    @Test
    public void getCurrentLabelName() {
        //Arrange
        String labelExpected = "Columbia Records";
        label.setName(labelExpected);
        artist.setCurrentLabel(label);
        //Act
        String result = artist.getCurrentLabelName();
        //Assert
        assertEquals(labelExpected, result);
    }

    @Test
    public void getCurrentLabelNameIfEmpty() {
        //Arrange
        String labelExpected = "Independent";
        //Act
        String result = artist.getCurrentLabelName();
        //Assert
        assertEquals(labelExpected, result);
    }
}