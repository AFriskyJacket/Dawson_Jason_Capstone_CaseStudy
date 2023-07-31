package com.Catpics.Dawson_Jason_Capstone_CaseStudy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DawsonJasonCapstoneCaseStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(DawsonJasonCapstoneCaseStudyApplication.class, args);
    }
}
