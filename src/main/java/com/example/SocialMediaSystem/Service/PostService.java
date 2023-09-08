package com.example.SocialMediaSystem.Service;

import com.example.SocialMediaSystem.Model.Notification;
import com.example.SocialMediaSystem.Model.Post;
import com.example.SocialMediaSystem.Model.User;
import com.example.SocialMediaSystem.Repository.PostRepository;
import com.example.SocialMediaSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public Post addPost(int userId)throws Exception {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()){
            throw new Exception("user not found");
        }
        Post post = new Post();
        User user = optionalUser.get();

        post.setPostId(user.getPostList().size()+1);
        post.setContent("post is added");
        post.setTime(new Date());
        post.setLikes(post.getLikes());
        post.setUser(user);


        user.getPostList().add(post);

        userRepository.save(user);
         post = postRepository.save(post);

        return post;
    }

    public void likePost(int userId, int post) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Post> optionalPost = postRepository.findById(post);

        if(optionalPost.isPresent() && optionalUser.isPresent()) {
            Post savedPost = optionalPost.get();
            savedPost.setLikes(savedPost.getLikes() + 1);
            postRepository.save(savedPost);

            Notification notification = new Notification();
            notification.setPost(savedPost);
            notification.setTime(new Date());
            User user = optionalUser.get();
            user.getNotificationList().add(notification);
            userRepository.save(user);
        }
    }
}
