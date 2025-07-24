package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.Board;
import pe.edu.utp.criollo_y_punto_api.repository.BoardRepository;
import pe.edu.utp.criollo_y_punto_api.service.BoardService;

/*
 * Este servicio implementa la lógica de negocio para la entidad Board, permitiendo gestionar sus operaciones básicas
 *  como listar, obtener, guardar, actualizar y eliminar entradas de Board. Utiliza BoardRepository para interactuar
 *  con la base de datos, delegando las operaciones CRUD a través de métodos proporcionados por JpaRepository, 
 * lo que facilita el acceso a los datos sin necesidad de escribir consultas manuales.
 */
@Service
public class BoardServiceImpl implements BoardService {
  @Autowired
  private BoardRepository boardRepository;

  @Override
  public List<Board> getAll() {
    return boardRepository.findAll();
  }

  @Override
  public Board get(Integer boardId) {
    return boardRepository.findById(boardId).orElse(null);
  }

  @Override
  public Board save(Board board) {
    return boardRepository.save(board);
  }

  @Override
  public Board update(Board board) {
    return boardRepository.save(board);
  }

  @Override
  public void delete(Integer boardId) {
    boardRepository.deleteById(boardId);
  }

}
