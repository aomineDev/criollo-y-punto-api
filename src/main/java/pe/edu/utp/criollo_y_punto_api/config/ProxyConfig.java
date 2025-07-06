package pe.edu.utp.criollo_y_punto_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.edu.utp.criollo_y_punto_api.service.MenuCategoryService;
import pe.edu.utp.criollo_y_punto_api.service.patron.proxy.MenuCategoryCache;

@Configuration
public class ProxyConfig {
  @Bean
  public MenuCategoryService menuCategoryService() {
    return new MenuCategoryCache();
  }
}
