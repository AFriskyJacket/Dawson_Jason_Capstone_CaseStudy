package com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.Dto;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

@Getter
@Setter
@ToString
public class CatEnjoyerDto {
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    private Collection<Role> role;
}
