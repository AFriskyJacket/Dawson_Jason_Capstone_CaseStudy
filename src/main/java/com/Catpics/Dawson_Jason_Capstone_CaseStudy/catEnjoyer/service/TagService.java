package com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.service;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model.Tag;

import java.util.Collection;

public interface TagService {
    Collection<String> findAllTags();

    void createNewTag(String newTagName);
}
