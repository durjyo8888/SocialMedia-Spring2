package com.example.SocialMediaSystem.Model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;
import java.util.Date;

//Post = Content, Time, User, Like;
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int postId;
    String content;
    int likes;
    Date time;

    @ManyToOne
    @JoinColumn
    User user;
}
