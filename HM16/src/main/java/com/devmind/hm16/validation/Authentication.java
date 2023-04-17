package com.devmind.hm16.validation;

import com.devmind.hm16.models.User;
import lombok.Data;

@Data
public class Authentication {
    private String firstName;
    private String lastName;
    private String email;

    public Authentication(User user){
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }
}
