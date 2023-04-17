package com.devmind.hm16.models;

import com.devmind.hm16.models.User;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
@Data
public class MyDatabase {
    //public ArrayList<User> myUsers = new ArrayList<>();
    public Map<String, User> myUsers = new HashMap<>();

}
