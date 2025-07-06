package pe.edu.utp.criollo_y_punto_api.service;

import java.util.List;

import pe.edu.utp.criollo_y_punto_api.model.MenuItem;

public interface MenuItemService {

    List<MenuItem> getAll();

    MenuItem get(Integer menuItemId);

    MenuItem save(MenuItem menuItem);

    MenuItem update(MenuItem menuItem);

    void delete(Integer menuItemId);

}
