package pe.edu.utp.criollo_y_punto_api.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pe.edu.utp.criollo_y_punto_api.model.MenuCategory;
import pe.edu.utp.criollo_y_punto_api.repository.MenuCategoryRepository;

import static org.mockito.Mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MenuCategoryServiceImplTest {
  @Mock
  private MenuCategoryRepository repository;

  @InjectMocks
  private MenuCategoryServiceImpl service;

  @Test
  void testGetById() {
    MenuCategory menuCategory = new MenuCategory();
    menuCategory.setMenuCategoryId(1);
    menuCategory.setName("bebidas");

    when(repository.findById(1)).thenReturn(Optional.of(menuCategory));

    MenuCategory result = service.get(1).orElse(null);

    assertEquals("bebidas", result.getName());
  }
}
