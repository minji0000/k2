package com.k2web.board.service;

import com.k2web.board.model.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class UserService {
  private final String NAMESPACE = "mapper.UserMapper";
  @Autowired
  private SqlSession sqlSession;

  public UserDTO auth(UserDTO u) {
    return sqlSession.selectOne(NAMESPACE+ ".auth", u);
  }

  public void register(UserDTO u) {
    sqlSession.insert(NAMESPACE+ ".register", u);

  }

  public UserDTO selectOne(int id) {
    return sqlSession.selectOne(NAMESPACE + ".selectOne", id);
  }
}
