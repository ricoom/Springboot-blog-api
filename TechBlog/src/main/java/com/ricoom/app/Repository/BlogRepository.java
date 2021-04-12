package com.ricoom.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricoom.app.models.BlogPost;

public interface BlogRepository extends JpaRepository<BlogPost, Long> {
   List<BlogPost>  findByBlogTitle(String title);
}
