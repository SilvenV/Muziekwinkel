package com.example.muziekwinkel.repositories;

import com.example.muziekwinkel.models.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {

    @Query("SELECT s FROM Label s WHERE s.name=?1")
    Label findLabelByName(String name);
}
