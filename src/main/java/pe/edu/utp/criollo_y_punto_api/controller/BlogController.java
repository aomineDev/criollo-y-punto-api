package pe.edu.utp.criollo_y_punto_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.utp.criollo_y_punto_api.model.Blog;
import pe.edu.utp.criollo_y_punto_api.service.BlogService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
  @Autowired
  private BlogService blogService;

  @GetMapping
  public ResponseEntity<List<Blog>> getBlogList() {
    return ResponseEntity.ok(blogService.getAll());
  }

  @PostMapping
  public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
    Blog createdBlog = blogService.save(blog);

    return ResponseEntity.status(HttpStatus.CREATED).body(createdBlog);
  }

}
