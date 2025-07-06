package pe.edu.utp.criollo_y_punto_api.service;

import java.util.List;

import pe.edu.utp.criollo_y_punto_api.model.Blog;

public interface BlogService {
  List<Blog> getAll();

  Blog get(Integer blogId);

  Blog save(Blog blog);

  Blog update(Blog blog);

  void delete(Integer blogId);
}
