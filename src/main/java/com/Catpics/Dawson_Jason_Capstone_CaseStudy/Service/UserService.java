package com.Catpics.Dawson_Jason_Capstone_CaseStudy.Service;

import com.Catpics.Dawson_Jason_Capstone_CaseStudy.Repository.UserRepository;
import com.Catpics.Dawson_Jason_Capstone_CaseStudy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User get(long id) {
        return userRepository.findById(id).get();
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
