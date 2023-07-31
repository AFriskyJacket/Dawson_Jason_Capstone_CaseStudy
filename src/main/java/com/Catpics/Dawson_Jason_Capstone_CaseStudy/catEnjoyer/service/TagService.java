package com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.service;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model.Tag;

import java.util.Collection;
import java.util.List;

public interface TagService {

    Collection<String> findAllTagNames();

    void createNewTag(String newTagName);

}
