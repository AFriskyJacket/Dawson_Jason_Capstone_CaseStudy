package com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.impl;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.Dto.CatEnjoyerDto;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model.CatEnjoyer;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model.Role;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.repo.CatEnjoyerRepository;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.repo.RoleRepository;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.service.CatEnjoyerService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CatEnjoyerServiceImpl implements CatEnjoyerService {

    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private CatEnjoyerRepository catEnjoyerRepository;
    @Override
    public void saveCatEnjoyer(CatEnjoyerDto catEnjoyerDto) {
        /*UserDetails user = User.builder()
                        .username(catEnjoyerDto.getUsername())
                                .password(passwordEncoder.encode(catEnjoyerDto.getPassword()))
                                        .roles(catEnjoyerDto.getRole().stream().collect(Collectors.toList()))
                                                .build();*/
        catEnjoyerRepository.save(mapDtoToCatEnjoyer(catEnjoyerDto));
    }

    @Override
    public CatEnjoyerDto findCatEnjoyerByUsername(String username) {
        return mapCatEnjoyerToDto(catEnjoyerRepository.findByUsername(username));
    }

    @Override
    public Collection<Role> getDefaultRole() {
        Optional<Role> role = roleRepository.findByName("ROLE_USER");
        if (role.isPresent()) {
            return role.stream().collect(Collectors.toList());
        }
        Role newRole = new Role("ROLE_USER");
        roleRepository.save(newRole);
        return Arrays.asList(newRole);
    }

    public boolean isValidCatEnjoyer(CatEnjoyerDto catEnjoyerDto) {
        boolean valid = false;
        //System.out.println(catEnjoyerDto + "validating");
        if (catEnjoyerRepository.existsByUsername(catEnjoyerDto.getUsername())){
            //System.out.println("valid check 1");
            if (passwordEncoder.matches(catEnjoyerDto.getPassword(),
                    catEnjoyerRepository.findByUsername(
                            catEnjoyerDto.getUsername())
                            .getPassword())) {
                //System.out.println("valid check 2");
                valid = true;
            }
        }
        System.out.println("finished validating");
        return valid;
    }

    private CatEnjoyerDto mapCatEnjoyerToDto(CatEnjoyer catEnjoyer) {
        CatEnjoyerDto dto = new CatEnjoyerDto();
        dto.setUsername(catEnjoyer.getUsername());
        dto.setPassword(catEnjoyer.getPassword());
        dto.setRole(catEnjoyer.getRoles());
        return dto;
    }
    private CatEnjoyer mapDtoToCatEnjoyer(CatEnjoyerDto dto){
        //System.out.println(dto);
        CatEnjoyer catEnjoyer = new CatEnjoyer();
        catEnjoyer.setUsername(dto.getUsername());
        //encrypts the password
        catEnjoyer.setPassword(passwordEncoder.encode(dto.getPassword()));
        catEnjoyer.setRoles(dto.getRole());
        System.out.println(catEnjoyer);
        return catEnjoyer;
    }

}
