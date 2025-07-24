package pe.edu.utp.criollo_y_punto_api.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pe.edu.utp.criollo_y_punto_api.model.Board;
import pe.edu.utp.criollo_y_punto_api.repository.BoardRepository;

@ExtendWith(MockitoExtension.class)
public class BoardServiceImplTest {
  @Mock
  private BoardRepository repository;

  @InjectMocks
  private BoardServiceImpl service;

  @Test
  void testGetById() {
    Board board = new Board();
    board.setBoardId(1);
    board.setNumber("1");

    when(repository.findById(1)).thenReturn(Optional.of(board));

    Board result = service.get(1).orElse(null);

    assertEquals("1", result.getNumber());
  }
}
