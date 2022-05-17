package com.example.muziekwinkel.repositories;

import com.example.muziekwinkel.models.Album;
import com.example.muziekwinkel.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("SELECT s FROM Album s WHERE s.name=?1")
    Album findAlbumByName(String name);
}
