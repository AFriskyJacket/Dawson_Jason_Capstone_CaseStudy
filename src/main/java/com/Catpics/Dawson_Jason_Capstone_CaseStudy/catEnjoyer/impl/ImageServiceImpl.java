package com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.impl;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.Dto.ImageDto;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model.ImageMetaData;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model.Tag;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.repo.CatEnjoyerRepository;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.repo.ImageMetaDataRepository;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.repo.TagRepository;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {

    private ImageMetaDataRepository metaDataRepository;
    private CatEnjoyerRepository catEnjoyerRepository;
    private TagRepository tagRepository;
    //Image actual data repository

    @Override
    public Collection<ImageDto> findAllImagesByTag(String tagName) {
        return metaDataRepository.findByTags_Name(tagName).stream().map(this::mapImageMetaDataToDto).collect(Collectors.toList());
    }

    @Override
    public Collection<ImageDto> findAllImagesByCreator(String username) {
        return metaDataRepository.findByCatEnjoyer_Username(username).stream().map(this::mapImageMetaDataToDto).collect(Collectors.toList());
    }

    @Override
    public ImageDto findImageByName(String name) {
        return mapImageMetaDataToDto(metaDataRepository.findByName(name).get());
    }

    @Override
    public void saveImage(ImageDto imageDto) {
        metaDataRepository.save(mapDtoToImageMetaData(imageDto));
    }

    private ImageDto mapImageMetaDataToDto(ImageMetaData imageMetaData){
        ImageDto dto = new ImageDto();
        dto.setCreator(imageMetaData.getCatEnjoyer().getUsername());
        dto.setImageName(imageMetaData.getName());
        dto.setTags(imageMetaData.getTags().stream().map(Tag::getName).collect(Collectors.toList()));
        return dto;
    }
    private ImageMetaData mapDtoToImageMetaData(ImageDto dto){
        ImageMetaData newData = new ImageMetaData();
        newData.setName(dto.getImageName());
        //Collection<Tag> allTags = tagRepository.findAll();
        if (!dto.getTags().isEmpty()) {
            newData.setTags(dto.getTags().stream().map(tag -> tagRepository.findByName(tag).get()).collect(Collectors.toList()));
        }
        newData.setCatEnjoyer(catEnjoyerRepository.findByUsername(dto.getCreator()));

        return newData;
    }


}
