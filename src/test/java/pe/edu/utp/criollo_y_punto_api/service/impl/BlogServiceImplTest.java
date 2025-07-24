package pe.edu.utp.criollo_y_punto_api.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pe.edu.utp.criollo_y_punto_api.model.Blog;
import pe.edu.utp.criollo_y_punto_api.repository.BlogRepository;

@ExtendWith(MockitoExtension.class)
public class BlogServiceImplTest {
  @Mock
  private BlogRepository repository;

  @InjectMocks
  private BlogServiceImpl service;

  @Test
  void testGetById() {
    Blog blog = new Blog();
    blog.setBlogId(1);
    blog.setTitle("Como cocinar un aji de gallina al estilo Criollo y Punto");

    when(repository.findById(1)).thenReturn(Optional.of(blog));

    Blog result = service.get(1).orElse(null);

    assertEquals("Como cocinar un aji de gallina al estilo Criollo y Punto", result.getTitle());
  }
}
