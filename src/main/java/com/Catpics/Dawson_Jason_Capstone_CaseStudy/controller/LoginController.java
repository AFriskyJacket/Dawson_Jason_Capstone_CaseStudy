package com.Catpics.Dawson_Jason_Capstone_CaseStudy.controller;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.Dto.CatEnjoyerDto;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.service.CatEnjoyerService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
class LoginController {

    private CatEnjoyerService catEnjoyerService;

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        CatEnjoyerDto dto = new CatEnjoyerDto();
        model.addAttribute("catEnjoyer", dto);
        return "register";
    }

    @PostMapping("/register/save")
    public String registerUser(@ModelAttribute(name = "catEnjoyer") CatEnjoyerDto catEnjoyerDto, BindingResult result, Model model){
        catEnjoyerDto.setRole(catEnjoyerService.getDefaultRole());
        //System.out.println(catEnjoyerDto);
        try {
            catEnjoyerService.saveCatEnjoyer(catEnjoyerDto);
            return "redirect:/register?success";
        } catch (DataIntegrityViolationException e){
            result.rejectValue("username", null, e.getMessage());
        }
        model.addAttribute("catEnjoyer", catEnjoyerDto);
        return "register";

    }
}