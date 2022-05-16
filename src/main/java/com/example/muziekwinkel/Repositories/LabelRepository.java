package com.example.muziekwinkel.Repositories;

import com.example.muziekwinkel.Models.Artist;
import com.example.muziekwinkel.Models.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {

    @Query("SELECT s FROM Label s WHERE s.name=?1")
    Label findLabelByName(String name);
}
