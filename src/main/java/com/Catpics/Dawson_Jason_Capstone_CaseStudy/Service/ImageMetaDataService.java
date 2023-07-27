package com.Catpics.Dawson_Jason_Capstone_CaseStudy.Service;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.Repository.ImageMetaDataRepository;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.model.ImageMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ImageMetaDataService {
    @Autowired
    private ImageMetaDataRepository imageMetaDataRepository;

    public List<ImageMetaData> listAll() {
        return imageMetaDataRepository.findAll();
    }

    public void save(ImageMetaData imageMetaData) {
        imageMetaDataRepository.save(imageMetaData);
    }

    public ImageMetaData get(long id) {
        return imageMetaDataRepository.findById(id).get();
    }

    public void delete(long id) {
        imageMetaDataRepository.deleteById(id);
    }
}
