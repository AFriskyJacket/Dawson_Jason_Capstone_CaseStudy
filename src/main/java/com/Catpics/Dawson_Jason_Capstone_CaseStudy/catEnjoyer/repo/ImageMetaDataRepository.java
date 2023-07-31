package com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.repo;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model.ImageMetaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface ImageMetaDataRepository extends JpaRepository<ImageMetaData, Long> {
    Optional<ImageMetaData> findByName(String name);
    Collection<ImageMetaData> findByCatEnjoyer_Username(String username);
    Collection<ImageMetaData> findByTags_Name(String name);
}