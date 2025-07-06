package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.MenuCategory;
import pe.edu.utp.criollo_y_punto_api.repository.MenuCategoryRepository;
import pe.edu.utp.criollo_y_punto_api.service.MenuCategoryService;

@Service
public class MenuCategoryServiceImpl implements MenuCategoryService {
  @Autowired
  private MenuCategoryRepository menuCategoryRepository;

  @Override
  public List<MenuCategory> getAll() {
    return menuCategoryRepository.findAll();
  }

  @Override
  public MenuCategory get(Integer menuCategoryId) {
    return menuCategoryRepository.findById(menuCategoryId).orElse(null);
  }

  @Override
  public MenuCategory save(MenuCategory menuCategory) {
    return menuCategoryRepository.save(menuCategory);
  }

  @Override
  public MenuCategory update(MenuCategory menuCategory) {
    return menuCategoryRepository.save(menuCategory);
  }

  @Override
  public void delete(Integer menuCategoryId) {
    menuCategoryRepository.deleteById(menuCategoryId);
  }

}
