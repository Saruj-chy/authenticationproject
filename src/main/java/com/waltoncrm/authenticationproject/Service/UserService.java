package com.waltoncrm.authenticationproject.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waltoncrm.authenticationproject.Dao.UserRepository;
import com.waltoncrm.authenticationproject.Model.User;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository ;

    List<User> userList = new ArrayList<>();

    public Long CreateUser(User user){
        User savedUser = userRepository.save(user);
        Long id = savedUser.getId();
        return id;
    }

    public List<User> readUsersAll(){
        List<User> userData =  userRepository.findAll();

        return userData;
    }

    public Optional<User> readUsersByIdl(Long id){
        Optional<User> userData = userRepository.findById(id);
        return userData;
    }

    public User updateUser(User user) {
        Optional<User> existingUserOpt = userRepository.findById(user.getId());

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            existingUser.setName(user.getName());
            existingUser.setPhone(user.getPhone());
            existingUser.setPassword(user.getPassword());
            existingUser.setAddress(user.getAddress());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with ID: " + user.getId());
        }
    }

    private boolean DeleteUser(Long Id){
        userRepository.deleteById(Id);
        return true;
    }
    
} 