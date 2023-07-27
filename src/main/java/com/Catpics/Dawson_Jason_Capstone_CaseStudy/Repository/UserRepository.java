package com.Catpics.Dawson_Jason_Capstone_CaseStudy.Repository;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}