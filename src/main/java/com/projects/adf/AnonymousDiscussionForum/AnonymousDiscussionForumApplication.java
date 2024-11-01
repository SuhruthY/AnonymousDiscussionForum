package com.projects.adf.AnonymousDiscussionForum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AnonymousDiscussionForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnonymousDiscussionForumApplication.class, args);
	}

}


@RestController
class Controller{
	
	@GetMapping
	String getAll() {
		return "Hello Render";
	}
	
}