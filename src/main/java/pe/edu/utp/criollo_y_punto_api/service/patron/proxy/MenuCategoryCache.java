package pe.edu.utp.criollo_y_punto_api.service.patron.proxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.utp.criollo_y_punto_api.model.MenuCategory;
import pe.edu.utp.criollo_y_punto_api.service.MenuCategoryService;

public class MenuCategoryCache implements MenuCategoryService {
  @Autowired
  private MenuCategoryService menuCategoryService;

  private List<MenuCategory> menuCategoryList;

  @Override
  public List<MenuCategory> getAll() {
    if (menuCategoryList == null) {
      System.out.println("[cache] cache vacia, obteniendo de la base de datos");
      menuCategoryList = menuCategoryService.getAll();
    } else {
      System.out.println("[cache] obteniendo datos de la cache");
    }

    return menuCategoryList;
  }

  @Override
  public MenuCategory get(Integer menuCategoryId) {
    return menuCategoryService.get(menuCategoryId);
  }

  @Override
  public MenuCategory save(MenuCategory menuCategory) {
    clear();
    return menuCategoryService.save(menuCategory);

  }

  @Override
  public MenuCategory update(MenuCategory menuCategory) {
    clear();
    return menuCategoryService.update(menuCategory);
  }

  @Override
  public void delete(Integer menuCategoryId) {
    clear();
    menuCategoryService.delete(menuCategoryId);
  }

  public void clear() {
    System.out.println("[cache] limpiando cache");
    menuCategoryList = null;
  }
}
