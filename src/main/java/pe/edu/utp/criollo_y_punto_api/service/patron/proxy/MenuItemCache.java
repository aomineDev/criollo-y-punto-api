package pe.edu.utp.criollo_y_punto_api.service.patron.proxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.utp.criollo_y_punto_api.model.MenuItem;
import pe.edu.utp.criollo_y_punto_api.service.MenuItemService;
import pe.edu.utp.criollo_y_punto_api.service.impl.MenuItemServiceImpl;

public class MenuItemCache implements MenuItemService {
    @Autowired
    MenuItemServiceImpl menuItemService;

    private List<MenuItem> menuItemList;

    @Override
    public List<MenuItem> getAll() {
        if (menuItemList == null) {
            System.out.println("[cache] cache vacia, obteniendo de la base de datos");
            menuItemList = menuItemService.getAll();
        } else {
            System.out.println("[cache] obteniendo datos de la cache");
        }

        return menuItemList;
    }

    @Override
    public MenuItem get(Integer menuItemid) {
        return menuItemService.get(menuItemid);
    }

    @Override
    public MenuItem save(MenuItem menuItem) {
        clear();
        return menuItemService.save(menuItem);
    }

    @Override
    public MenuItem update(MenuItem menuItem) {
        clear();
        return menuItemService.update(menuItem);
    }

    @Override
    public void delete(Integer menuItemid) {
        clear();
        menuItemService.delete(menuItemid);
    }

    public void clear() {
        System.out.println("[cache] limpiando cache");
        menuItemList = null;
    }

}
