package com.devmind.hm16.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
@Data
public class Authenticated {
    public Set<String> myAuthenticatedUsers = new HashSet<>();
}
