package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.MenuCategory;
import pe.edu.utp.criollo_y_punto_api.repository.MenuCategoryRepository;
import pe.edu.utp.criollo_y_punto_api.service.MenuCategoryService;

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
