package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.MenuCategory;
import pe.edu.utp.criollo_y_punto_api.repository.MenuCategoryRepository;
import pe.edu.utp.criollo_y_punto_api.service.MenuCategoryService;

/*
 * Este servicio implementa la lógica de negocio para la entidad MenuCategory, permitiendo gestionar sus operaciones básicas
 *  como listar, obtener, guardar, actualizar y eliminar entradas de MenuCategory. Utiliza MenuCategoryRepository para interactuar
 *  con la base de datos, delegando las operaciones CRUD a través de métodos proporcionados por JpaRepository, 
 * lo que facilita el acceso a los datos sin necesidad de escribir consultas manuales.
 */
@Service
public class MenuCategoryServiceImpl implements MenuCategoryService {
  @Autowired
  private MenuCategoryRepository repository;

  @Override
  public List<MenuCategory> getAll() {
    return repository.findAll();
  }

  @Override
  public Optional<MenuCategory> get(Integer menuCategoryId) {
    return repository.findById(menuCategoryId);
  }

  @Override
  public MenuCategory save(MenuCategory menuCategory) {
    return repository.save(menuCategory);
  }

  @Override
  public Optional<MenuCategory> update(Integer id, MenuCategory menuCategory) {
    return repository.findById(id)
        .map(existingMenuCategory -> {
          menuCategory.setMenuCategoryId(id);

          return repository.save(menuCategory);
        });
  }

  @Override
  public void delete(Integer menuCategoryId) {
    repository.findById(menuCategoryId)
        .ifPresent(menuCategory -> repository.delete(menuCategory));
  }

}
