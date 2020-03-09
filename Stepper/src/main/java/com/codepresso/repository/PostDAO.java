package com.codepresso.repository;

import java.util.List;

import com.codepresso.domain.PostAndUserVO;
import com.codepresso.domain.PostVO;

public interface PostDAO {

	public int savePost(PostVO postVO) throws Exception;
	
	public PostVO findPostById(Long id) throws Exception;
	
	public List<PostAndUserVO> findAllPost() throws Exception;
	
	public List<PostAndUserVO> findMyPost(Long id) throws Exception;
	
	public PostAndUserVO postDetailById(Long id) throws Exception;

	public int deletePostById(Long id) throws Exception;
	
}
