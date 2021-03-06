package com.codepresso.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codepresso.domain.PostAndUserVO;
import com.codepresso.domain.PostVO;

@Repository
public class PostDAOImpl implements PostDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PostDAOImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String Namespace = "mybatis.mappers.post";
	
	@Override
	public int savePost(PostVO postVO) throws Exception {
		logger.info("call savePost() method in PostDAOImpl");
		
		int result = sqlSession.insert(Namespace + ".savePost", postVO);
		return result;
	}

	@Override
	public PostVO findPostById(Long id) throws Exception {
		logger.info("call findPostById() method in PostDAOImpl");
		
		PostVO result = sqlSession.selectOne(Namespace + ".findPostById", id);
		return result;
	}
	
	@Override
	public List<PostAndUserVO> findAllPost() throws Exception {
		logger.info("call findAllPost() method in PostDAOImpl");
		
		List<PostAndUserVO> result = sqlSession.selectList(Namespace + ".findAllPost");
		return result;
	}

	@Override
	public List<PostAndUserVO> findMyPost(Long id) throws Exception {
		logger.info("call findMyPost() method in PostDAOImpl");
		
		List<PostAndUserVO> result = sqlSession.selectList(Namespace + ".findMyPost", id);
		return result;
	}
	
	@Override
	public PostAndUserVO postDetailById(Long id) throws Exception {
		logger.info("call postDetailById() method in PostDAOImpl");
		
		PostAndUserVO result = sqlSession.selectOne(Namespace + ".PostDetailById", id);
		return result;
	}

	@Override
	public int deletePostById(Long id) throws Exception {
		int result = sqlSession.delete(Namespace + ".deletePostById", id);
		return result;
	}

}
