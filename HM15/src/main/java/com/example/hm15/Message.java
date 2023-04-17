package com.example.hm15;

import lombok.Data;

@Data
public class Message {
    private String sender;
    private String receiver;
    private String text;
    private boolean seen;
    private String sentDate;
}
