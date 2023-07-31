package com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.repo;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model.CatEnjoyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatEnjoyerRepository extends JpaRepository<CatEnjoyer, Long> {
    boolean existsByUsername(String username);
    CatEnjoyer findByUsername(String username);
}