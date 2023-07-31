package com.Catpics.Dawson_Jason_Capstone_CaseStudy.security;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model.CatEnjoyer;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.repo.CatEnjoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatEnjoyerDetailsService implements UserDetailsService {

    private final CatEnjoyerRepository catEnjoyerRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CatEnjoyer catEnjoyer = catEnjoyerRepository.findByUsername(username);
        if (catEnjoyer!=null){
            return new User(catEnjoyer.getUsername(), catEnjoyer.getPassword(), catEnjoyer.getRoles().stream()
                    .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
        } else throw new UsernameNotFoundException("Invalid username or Password Meow");
    }


}
