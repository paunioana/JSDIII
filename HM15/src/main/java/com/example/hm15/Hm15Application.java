package com.example.hm15;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Hm15Application {

	public static void main(String[] args) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Course course = objectMapper.readValue(new File("src/main/resources/static/input.json"), Course.class);
		System.out.println(course.getCourseName());

		Conversation conversation = objectMapper.readValue(new File("src/main/resources/static/input2.json"), Conversation.class);
		System.out.println(conversation.getMessages().size());
		SpringApplication.run(Hm15Application.class, args);

	}

}
