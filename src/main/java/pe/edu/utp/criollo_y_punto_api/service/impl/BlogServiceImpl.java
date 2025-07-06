package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.Blog;
import pe.edu.utp.criollo_y_punto_api.repository.BlogRepository;
import pe.edu.utp.criollo_y_punto_api.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {
  @Autowired
  private BlogRepository blogRepository;

  @Override
  public List<Blog> getAll() {
    return blogRepository.findAll();
  }

  @Override
  public Blog get(Integer blogId) {
    return blogRepository.findById(blogId).orElse(null);
  }

  @Override
  public Blog save(Blog blog) {
    return blogRepository.save(blog);
  }

  @Override
  public Blog update(Blog blog) {
    return blogRepository.save(blog);
  }

  @Override
  public void delete(Integer blogId) {
    blogRepository.deleteById(blogId);
  }
}
