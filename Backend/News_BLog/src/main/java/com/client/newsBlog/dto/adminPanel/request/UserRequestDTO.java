package com.client.newsBlog.dto.adminPanel.request;

import lombok.Data;

@Data
public class UserRequestDTO {
    String email;
    String password;
    String roleName;
    String country;
    String city;
    String state;
    String address;
    String age;
    String firstName;
    String lastName;
    String gender;
    String phoneNumber;
    String activeStatus;
}
