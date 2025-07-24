package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.Blog;
import pe.edu.utp.criollo_y_punto_api.repository.BlogRepository;
import pe.edu.utp.criollo_y_punto_api.service.BlogService;

/*
 * Este servicio implementa la lógica de negocio para la entidad Blog, permitiendo gestionar sus operaciones básicas
 *  como listar, obtener, guardar, actualizar y eliminar entradas de blog. Utiliza BlogRepository para interactuar
 *  con la base de datos, delegando las operaciones CRUD a través de métodos proporcionados por JpaRepository, 
 * lo que facilita el acceso a los datos sin necesidad de escribir consultas manuales.
 */
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
