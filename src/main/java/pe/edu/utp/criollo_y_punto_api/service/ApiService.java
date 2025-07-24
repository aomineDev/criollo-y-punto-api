package pe.edu.utp.criollo_y_punto_api.service;

import java.util.List;
import java.util.Optional;

public interface ApiService<T> {
  List<T> getAll();

  Optional<T> get(Integer id);

  T save(T entity);

  Optional<T> update(Integer id, T entity);

  void delete(Integer id);
}
