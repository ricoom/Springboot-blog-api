package com.ricoom.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="blog_post")
public class BlogPost {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
@NotNull
private String blogTitle;
@NotNull
@Lob
private String blogContent;

private String publishedDate;




public BlogPost() {
	
}

public BlogPost(String blogTitle, String blogContent, String publishedDate) {
	super();
	this.blogTitle = blogTitle;
	this.blogContent = blogContent;
	this.publishedDate = publishedDate;
}

public String getBlogTitle() {
	return blogTitle;
}

public void setBlogTitle(String blogTitle) {
	this.blogTitle = blogTitle;
}

public String getBlogContent() {
	return blogContent;
}

public void setBlogContent(String blogContent) {
	this.blogContent = blogContent;
}

public String getPublishedDate() {
	return publishedDate;
}

public void setPublishedDate(String publishedDate) {
	this.publishedDate = publishedDate;
}

@Override
public String toString() {
	return "BlogPost [blogTitle=" + blogTitle + ", blogContent=" + blogContent + ", publishedDate=" + publishedDate
			+ "]";
} 


}
