package com.example.muziekwinkel.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArtistTest {
Artist artist;
Label label;
    @Before
    public void setUp() throws Exception {
        artist = new Artist("Archibald Testartist", 2000);
        label = new Label();
    }

    @After
    public void tearDown() throws Exception {
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

    @Test
    public void addAlbum() {
    }

    @Test
    public void getArtistId() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void getYearFounded() {
    }

    @Test
    public void getCurrentLabel() {
    }

    @Test
    public void getReleasedAlbums() {
    }

    @Test
    public void setArtistId() {
    }

    @Test
    public void setName() {
    }

    @Test
    public void setYearFounded() {
    }

    @Test
    public void setCurrentLabel() {
    }

    @Test
    public void setCurrentLabelName() {
    }

    @Test
    public void setReleasedAlbums() {
    }
}