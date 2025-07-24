package pe.edu.utp.criollo_y_punto_api.service;

import java.util.List;

/*Esta interfaz genérica define un contrato para servicios que manejan operaciones
*CRUD básicas (obtener todos, obtener por ID, guardar, actualizar y eliminar). Utiliza el tipo genérico <T> para representar
*cualquier entidad, lo que permite reutilizar este mismo conjunto de métodos con diferentes modelos del sistema, evitando 
*duplicación de código y facilitando una arquitectura más limpia y mantenible.
 */
public interface ApiService<T> {
  List<T> getAll();

  T get(Integer id);

  T save(T entity);

  T update(T entity);

  void delete(Integer id);
}
