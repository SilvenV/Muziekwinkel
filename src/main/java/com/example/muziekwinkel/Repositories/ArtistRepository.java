package com.example.muziekwinkel.Repositories;

import com.example.muziekwinkel.Models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    @Query("SELECT s FROM Artist s WHERE s.name=?1")
    Artist findArtistByName(String name);
}