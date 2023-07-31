package com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.service;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.Dto.ImageDto;

import java.util.Collection;

public interface ImageService {
    Collection<ImageDto> findAllImagesByTag(String tag);
    Collection<ImageDto> findAllImagesByCreator(String username);
    ImageDto findImageByName(String name);
    void saveImage(ImageDto imageDto);
}
