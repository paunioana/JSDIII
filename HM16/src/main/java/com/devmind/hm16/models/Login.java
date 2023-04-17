package com.devmind.hm16.models;

import com.devmind.hm16.validation.EmailConstraint;
import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Data
public class Login {
    @NotNull(message = "email must be not-null")
    @NotBlank(message = "email must be not-null")
    @Email
    private String email;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
            message = "password must have digit + lowercase + uppercase + punctuation + symbol")
    @NotBlank(message = "password must be not-null")
    @NotNull(message = "password must be not-null")
    private String password;
}
