package com.example.SocialMediaSystem.Service;

import com.example.SocialMediaSystem.Model.User;
import com.example.SocialMediaSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public void addUser(User user) {
        user.setNotificationList(new ArrayList<>());
        user.setPostList(new ArrayList<>());
        userRepository.save(user);
    }

    public int getMaxNoOfNotificationByUser() {
        int userId = 0;
        int maxNotification = 0;
        List<User> userList = userRepository.findAll();
        for(User curruser : userList){
            if(maxNotification < curruser.getNotificationList().size()){
                maxNotification = curruser.getNotificationList().size();
                userId = curruser.getUserId();
            }
        }
        return userId;
    }
}
