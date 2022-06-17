package edu.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.board.vo.UserVO;

@Repository
public class UserDAO {

	@Autowired
	SqlSession sqlSession;
	
	public int insert(UserVO vo) {
		
		int result = sqlSession.insert("edu.board.mapper.userMapper.insert", vo);
		
		return result;
	}
	
	public UserVO selectByLogin(UserVO vo) {
		return sqlSession.selectOne("edu.board.mapper.userMapper.selectByLogin",vo);
	}
	
	public UserVO selectByMypage(int midx) {
		return sqlSession.selectOne("edu.board.mapper.userMapper.selectByMypage",midx);
	}
}
