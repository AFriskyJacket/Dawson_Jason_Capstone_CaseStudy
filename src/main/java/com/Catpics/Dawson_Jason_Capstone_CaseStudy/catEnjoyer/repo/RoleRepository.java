package com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.repo;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}