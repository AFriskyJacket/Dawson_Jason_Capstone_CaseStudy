package com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.impl;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model.Tag;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.repo.TagRepository;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TagServiceImpl implements TagService {
    private TagRepository tagRepository;
    @Override
    public Collection<String> findAllTags() {
        return tagRepository.findAll().stream().map(Tag::getName).collect(Collectors.toList());
    }

    @Override
    public void createNewTag(String newTagName) {
        tagRepository.save(new Tag(newTagName));
    }
}
