package com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.service;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.Dto.CatEnjoyerDto;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model.Role;

import java.util.Collection;

public interface CatEnjoyerService {
    void saveCatEnjoyer(CatEnjoyerDto catEnjoyerDto);
    CatEnjoyerDto findCatEnjoyerByUsername(String username);
    Collection<Role> getDefaultRole();
    public boolean isValidCatEnjoyer(CatEnjoyerDto catEnjoyerDto);
}
