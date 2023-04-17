package com.devmind.hm16.models;

import com.devmind.hm16.validation.EmailConstraint;
import lombok.Data;
import org.springframework.http.HttpStatusCode;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


@Data
public class User {
    @NotNull(message = "firstName must be not-null")
    @NotBlank(message = "firstName must be a non-empty string")
    private String firstName;
    @NotNull(message = "lastName must be not-null")
    @NotBlank(message = "lastName must be a non-empty string")
    private String lastName;

    @NotNull(message = "email must be not-null")
    @NotBlank(message = "email must be not-null")
    @Email
    @EmailConstraint
    private String email;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
            message = "password must have digit + lowercase + uppercase + punctuation + symbol")
    @NotBlank(message = "password must be not-null")
    @NotNull(message = "password must be not-null")
    private String password;
}
