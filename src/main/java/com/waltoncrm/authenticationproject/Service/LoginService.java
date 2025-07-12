package com.waltoncrm.authenticationproject.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waltoncrm.authenticationproject.Dao.UserRepository;
import com.waltoncrm.authenticationproject.Model.User;

@Service
public class LoginService {
    @Autowired
    UserRepository userRepository ;

    List<User> userList = new ArrayList<>();

    public Optional<User> findByNameAndPassword(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);
    }
}
