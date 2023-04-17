package com.devmind.hm16.controllers;

import com.devmind.hm16.models.Authenticated;
import com.devmind.hm16.models.Login;
import com.devmind.hm16.models.MyDatabase;
import com.devmind.hm16.models.User;
import com.devmind.hm16.validation.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


@RestController
@Component
public class UserController {
    @Autowired
    MyDatabase myDatabase;
    @Autowired
    Authenticated authenticated;
    @PostMapping("/register")
    public User handleRegister(@Valid @RequestBody User user) {
        String email = user.getEmail();

        if(myDatabase.getMyUsers().containsKey(email) == false) {
            //Save the user to your in-memory data-store;
            myDatabase.getMyUsers().put(email, user);
        }
        return user;
    }

    @GetMapping("/login")
    public ResponseEntity authenticate(@RequestBody @Valid Login login){
        String email = login.getEmail();
        String pass = login.getPassword();
        if(email != null && myDatabase.getMyUsers().containsKey(email) == true) {
            User user = myDatabase.getMyUsers().get(email);
            if(user.getPassword().equals(pass)) {
                if(authenticated.getMyAuthenticatedUsers().contains(email)) {
                    return new ResponseEntity<Object>("user is already authenticated", HttpStatusCode.valueOf(200));
                } else {
                    //add to authenticatedList
                    authenticated.getMyAuthenticatedUsers().add(email);
                    System.out.println(authenticated.toString());
                    Authentication returnUser = new Authentication(user);
                    return new ResponseEntity<Object>(returnUser, HttpStatusCode.valueOf(200));
                }
            } else {
                return new ResponseEntity<Object>("password does not match!", HttpStatusCode.valueOf(400));
            }
        } else {
            return new ResponseEntity<>("user does not exist!", HttpStatusCode.valueOf(400));
        }
    }
    @PostMapping("/logout/{email}")
    public ResponseEntity logoutUser(@PathVariable(value="email") String email){
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if(Pattern.compile(regexPattern).matcher(email).matches()) {
            if(authenticated.getMyAuthenticatedUsers().contains(email)) {
                authenticated.getMyAuthenticatedUsers().remove(email);
                return new ResponseEntity("you are now logged out", HttpStatusCode.valueOf(200));
            } else {
                return new ResponseEntity("this e-mail is not authenticated", HttpStatusCode.valueOf(400));
            }
        } else {
            return new ResponseEntity("please enter a valid e-mail", HttpStatusCode.valueOf(400));
        }

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
