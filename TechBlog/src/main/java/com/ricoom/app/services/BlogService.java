package com.ricoom.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricoom.app.Repository.BlogRepository;
import com.ricoom.app.models.BlogPost;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	public BlogPost newBlog(BlogPost blog) {
		BlogPost theBlog=new BlogPost();
		theBlog.setBlogTitle(blog.getBlogTitle());
		theBlog.setBlogContent(blog.getBlogContent());
		theBlog.setPublishedDate(blog.getPublishedDate());
		
		return blogRepository.save(theBlog);
	}
	
	public List<BlogPost> getAll(String title){
		List<BlogPost> blogs=new ArrayList<BlogPost>();
		if(title==null) {
			blogRepository.findAll().forEach(blogs::add);

		}else 
			blogRepository.findByBlogTitle(title).forEach(blogs::add);
		
		return blogs;
	}
	
}
