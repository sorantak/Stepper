package com.codepresso.repository;

import java.util.List;

import com.codepresso.domain.PostAndUserVO;
import com.codepresso.domain.PostVO;

public interface PostDAO {

public int savePost(PostVO postVO);
	
	public PostVO findPostById(Long id);
	
	public List<PostAndUserVO> findAllPost();
	
	public List<PostAndUserVO> findMyPost(Long id);
	
	public PostAndUserVO postDetailById(Long id);

	public int deletePostById(Long id);
	
}
