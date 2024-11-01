package com.projects.adf.AnonymousDiscussionForum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@SpringBootApplication
public class AnonymousDiscussionForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnonymousDiscussionForumApplication.class, args);
	}

}


@RestController
class ADFController{
	
	@Autowired
	DiscussionRepository discussionRepo;
	
	@Autowired
	CommentRepository commentRepo;
	
	 @GetMapping
	    public List<Discussion> getAllDiscussions() {
	        return discussionRepo.findAll();
	    }

	    @GetMapping("/{id}/comments")
	    public List<Comment> getCommentsByDiscussionId(@PathVariable Long id) {
	        return commentRepo.findAllByDiscussionId(id);
	    }
}

@Entity
@Data
class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String userId;
}

@Entity
@Data
class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String userId;

    @ManyToOne
    @JoinColumn(name = "discussion_id")
    private Discussion discussion;

}

interface DiscussionRepository extends JpaRepository<Discussion, Long> {
}

interface CommentRepository extends JpaRepository<Comment, Long> {
	
	List<Comment> findAllByDiscussionId(Long discussionId);
}