package com.Catpics.Dawson_Jason_Capstone_CaseStudy.Repository;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.model.ImageMetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImageMetaDataRepository extends JpaRepository<ImageMetaData, Long>, JpaSpecificationExecutor<ImageMetaData> {
}