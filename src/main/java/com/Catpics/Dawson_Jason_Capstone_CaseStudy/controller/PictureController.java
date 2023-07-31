package com.Catpics.Dawson_Jason_Capstone_CaseStudy.controller;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.Dto.CatEnjoyerDto;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.Dto.ImageDto;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model.Tag;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.repo.TagRepository;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.service.CatEnjoyerService;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.service.ImageService;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.service.TagService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class PictureController {

    private TagService tagService;
    private CatEnjoyerService catEnjoyerService;
    private ImageService imageService;
    @GetMapping("/index")
    public ModelAndView index(Model model){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");

        return mv;
    }
    @GetMapping("/upload")
    public ModelAndView uploadForm(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("upload_form");

        CatEnjoyerDto catEnjoyerDto = new CatEnjoyerDto();
        ImageDto imageDto = new ImageDto();
        Collection<String> tagNames = tagService.findAllTags();

        mv.addObject("catEnjoyer", catEnjoyerDto);
        mv.addObject("metaData", imageDto );
        mv.addObject("allTags", tagNames);

        return mv;
    }
    @PostMapping("/upload/newMeta")
    public ModelAndView uploadImage(@Valid @ModelAttribute("metaData") ImageDto imageDto,
                                    @Valid @ModelAttribute("catEnjoyer") CatEnjoyerDto catEnjoyerDto,
                                    @Valid @ModelAttribute("checkedTags") Collection<String> tagNames){
        ModelAndView newMV = new ModelAndView();
        System.out.println(imageDto);
        System.out.println(catEnjoyerDto);
        System.out.println(tagNames);
        imageDto.setCreator(catEnjoyerDto.getUsername());
        if (catEnjoyerService.isValidCatEnjoyer(catEnjoyerDto)){
            System.out.println("We valid boys");
            imageDto.setTags(tagNames);
            try {
                imageService.saveImage(imageDto);
                System.out.println("image saved?");
                newMV.setViewName("redirect:/upload?success");
                return newMV;
            } catch (DataIntegrityViolationException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("dang");
        newMV = uploadForm();
        return newMV;
    }
    @GetMapping("/search/{tag}")
    public ModelAndView viewImagesByTags(@PathVariable(value = "tag") String tagName){
        ModelAndView mv = searchImages();
        System.out.println("tag: " + tagName);

        mv.addObject("imagesMeta", imageService.findAllImagesByTag(tagName));
        return mv;
    }
    /*@GetMapping("/search/{username}")
    public ModelAndView viewImagesByUsername(@PathVariable(value = "username") String username){
        ModelAndView mv = new ModelAndView();
        System.out.println("username: " + username );
        mv.setViewName("images");
        return mv;
    }*/
    @GetMapping("/search")
    public ModelAndView searchImages(){
        ModelAndView mv = new ModelAndView("images");
        mv.addObject("tags",tagService.findAllTags());
        System.out.println(tagService.findAllTags().toString());
        return mv;
    }
    @GetMapping("/newTag/{tagName}")
    public ModelAndView createNewTag(@PathVariable(value = "tagName") String newTagName){
        try {
            tagService.createNewTag(newTagName);
        } catch (DataIntegrityViolationException e){
            System.out.println(e.getMessage());
        }
        return new ModelAndView("redirect:/index");
    }
}
