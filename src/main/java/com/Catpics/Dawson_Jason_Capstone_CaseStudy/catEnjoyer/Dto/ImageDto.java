package com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.Dto;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model.CatEnjoyer;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model.Tag;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
@Getter
@Setter
@ToString
public class ImageDto {
    @NotEmpty
    private String imageName;
    //i guess we can allow untagged images?
    private Collection<String> tags;
    @NotEmpty
    private String creator;

}
