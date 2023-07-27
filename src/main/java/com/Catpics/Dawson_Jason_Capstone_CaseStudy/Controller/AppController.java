package com.Catpics.Dawson_Jason_Capstone_CaseStudy.Controller;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.Service.ImageMetaDataService;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.Service.UserService;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.model.ImageMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private ImageMetaDataService imageMetaDataService;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<ImageMetaData> metaDataList = imageMetaDataService.listAll();
        model.addAttribute("metaDataList", metaDataList);

        return "index";
    }
    @RequestMapping("/new")
    public String showUploadImage(Model model) {
        ImageMetaData imageMetaData = new ImageMetaData();
        model.addAttribute("imageData", imageMetaData);

        return "upload_image";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String uploadImage(@ModelAttribute("imageData") ImageMetaData imageMetaData) {
        imageMetaDataService.save(imageMetaData);

        return "redirect:/";
    }
}
