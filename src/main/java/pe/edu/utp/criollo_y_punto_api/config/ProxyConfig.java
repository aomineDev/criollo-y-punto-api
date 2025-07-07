package pe.edu.utp.criollo_y_punto_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.edu.utp.criollo_y_punto_api.service.MenuCategoryService;
import pe.edu.utp.criollo_y_punto_api.service.MenuItemService;
import pe.edu.utp.criollo_y_punto_api.service.patron.proxy.MenuCategoryCache;
import pe.edu.utp.criollo_y_punto_api.service.patron.proxy.MenuItemCache;

@Configuration
public class ProxyConfig {
  @Bean
  public MenuCategoryService menuCategoryService() {
    return new MenuCategoryCache();
  }

  @Bean
  public MenuItemService menuItemService() {
    return new MenuItemCache();
  }
}
