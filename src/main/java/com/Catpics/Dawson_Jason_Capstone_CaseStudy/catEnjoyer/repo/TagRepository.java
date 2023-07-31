package com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.repo;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Collection<Tag> findByName(String name);

}