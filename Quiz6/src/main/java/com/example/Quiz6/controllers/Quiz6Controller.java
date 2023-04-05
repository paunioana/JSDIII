package com.example.Quiz6.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Quiz6Controller {

    @RequestMapping(value = "/add/first/{first}/second/{second}", method = RequestMethod.GET)
    public Double time(@PathVariable("first") String first, @PathVariable("second") String second){
        return Double.valueOf(first) + Double.valueOf(second);
    }
}
