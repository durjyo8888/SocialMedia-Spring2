package com.example.SocialMediaSystem.Controller;

import com.example.SocialMediaSystem.Model.Post;
import com.example.SocialMediaSystem.Model.User;
import com.example.SocialMediaSystem.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/add-post/{userId}")
    public ResponseEntity addPost(@PathVariable int userId) {
        try {
            Post savedpost = postService.addPost(userId);

            return new ResponseEntity(savedpost, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/put-like/{userId}/{post}")
    public ResponseEntity likePost(@PathVariable int userId, @PathVariable int post){
        postService.likePost(userId,post);
        return new ResponseEntity("updated successfully", HttpStatus.OK);
    }
}
