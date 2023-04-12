package com.example.test.Authentication;

import com.example.test.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest{

    public RegisterRequest(User user){
        name = user.getName();
        email = user.getEmail();
        password = user.getPassword();
        country = user.getCountry();
        city = user.getCity();
        gender = user.getGender();
    }
    private String name;
    private String email;
    private String password;
    private String country;
    private String city;
    private String gender;

}
