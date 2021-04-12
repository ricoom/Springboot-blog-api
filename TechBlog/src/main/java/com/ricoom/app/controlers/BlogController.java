package com.ricoom.app.controlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ricoom.app.models.BlogPost;
import com.ricoom.app.services.BlogService;

@RestController
@RequestMapping("/api")
public class BlogController {
	@Autowired
	private BlogService blogService;
	@PostMapping("/add")
	public ResponseEntity<BlogPost>newBlog(@RequestBody BlogPost blog){
		try {
			BlogPost _blog=blogService.newBlog(blog);
			return new  ResponseEntity<>(_blog,HttpStatus.CREATED);
		} catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/all")
 public ResponseEntity<List<BlogPost>> allBlogs(@RequestParam(required = false) String title){
	 List<BlogPost> blogs=new ArrayList<BlogPost>();
	 
	 blogService.getAll(title).forEach(blogs::add);
	 if (blogs.isEmpty()) {
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 }
	  return new ResponseEntity<>(blogs,HttpStatus.OK);
	 
 }
}
