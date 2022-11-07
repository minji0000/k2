package com.k2web.board.service;

import com.k2web.board.model.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@Repository
public class BoardService {
  private final String NAMESPACE = "mapper.BoardMapper";
  private final int PAGE_SIZE = 10;

  @Autowired
  SqlSession sqlSession;

  public List<BoardDTO> selectAll(int pageNo) {
    HashMap<String, Integer> map = new HashMap<>();

    int startNum = (pageNo - 1) * PAGE_SIZE ;

    map.put("startNum", startNum);
    map.put("PAGE_SIZE", PAGE_SIZE);

    return sqlSession.selectList(NAMESPACE + ".selectAll", map);
  }

  public BoardDTO selectOne(int boardId) {
    return sqlSession.selectOne(NAMESPACE + ".selectOne", boardId);
  }

  public int selectLastPage() {
    int total = sqlSession.selectOne(NAMESPACE + ".count");

    if(total % PAGE_SIZE == 0) {
      return total / PAGE_SIZE;

    } else {
      return (total/ PAGE_SIZE) + 1;
    }
  }

  public void insert(BoardDTO b) {
    sqlSession.insert(NAMESPACE + ".insert", b);
  }

  public void update(BoardDTO b) {
    sqlSession.update(NAMESPACE + ".update", b);
  }

  public void delete(int boardId) {
    sqlSession.delete(NAMESPACE + ".delete", boardId);
  }


}
