package com.example.SocialMediaSystem.Model;

//Notification = Post, Time
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int notificationId;

    Date time;

    @ManyToOne
    @JoinColumn
    Post post;

    @ManyToOne
    @JoinColumn
    User user;
}
