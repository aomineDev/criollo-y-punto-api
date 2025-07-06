package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.Board;
import pe.edu.utp.criollo_y_punto_api.repository.BoardRepository;
import pe.edu.utp.criollo_y_punto_api.service.BoardService;

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
