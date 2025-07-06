package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.MenuItem;
import pe.edu.utp.criollo_y_punto_api.repository.MenuItemRepository;
import pe.edu.utp.criollo_y_punto_api.service.MenuItemService;

@Service
public class MenuItemImpl implements MenuItemService{

  @Autowired
  private MenuItemRepository menuItemRepository;

  @Override
  public List<MenuItem> getAll() {
    return menuItemRepository.findAll();
  }

  @Override
  public MenuItem get(Integer menuItemId) {
    return menuItemRepository.findById(menuItemId).orElse(null);
  }

  @Override
  public MenuItem save(MenuItem menuItem) {
    return menuItemRepository.save(menuItem);
  }

  @Override
  public MenuItem update(MenuItem menuItem) {
    return menuItemRepository.save(menuItem);
  }

  @Override
  public void delete(Integer menuItemId) {
    menuItemRepository.deleteById(menuItemId);
  }

}
