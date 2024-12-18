package com.client.newsBlog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String password;
    @Column(name = "user_image_path")
    private String userImagePath;
    @Column(name = "role_name")
    private String roleName;
    @Column(name= "license_no")
    private String licenseNo;
    @Column(name = "online_status")
    private boolean onlineStatus = false;
    @Column(name = "access_status")
    private boolean accessStatus = true;
    @Column(name = "total_published_posts")
    private int totalPublishedPosts = 0;
    private String gender;
    private String age;
    private String address;


    @ManyToOne
    @JoinColumn(name = "cities_id")                  //fk
    private Cities cities;
    @ManyToOne
    @JoinColumn(name = "state_id")                  //fk
    private States states;
    @ManyToOne
    @JoinColumn(name = "countriesAndCodes")                  //fk
    private CountriesCodes countriesCodes;

    @CreationTimestamp
    @Column(name="datecreated", updatable = false)
    private Timestamp dateCreated;
    @UpdateTimestamp
    private Timestamp updatedAt;

    public User(String firstName, String email, String password, String roleName) {
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.roleName = roleName;
    }

    public User() {
    }
}
