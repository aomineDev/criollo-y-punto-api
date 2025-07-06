package pe.edu.utp.criollo_y_punto_api.service;

import java.util.List;

public interface ApiService<T> {
  List<T> getAll();

  T get(Integer id);

  T save(T entity);

  T update(T entity);

  void delete(Integer id);
}
