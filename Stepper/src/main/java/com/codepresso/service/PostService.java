package com.codepresso.service;

import com.codepresso.domain.PostVO;
import com.codepresso.domain.ResponseData;

public interface PostService {

	public ResponseData savePost(PostVO postVO, String accesstoken) throws Exception;

	public ResponseData findAllPost(String accesstoken) throws Exception;

	public ResponseData findMyPost(String accesstoken) throws Exception;

	public ResponseData postDetailById(Long id) throws Exception;

	public ResponseData deletePostById(Long id) throws Exception;

	public ResponseData viewMyFeedList(String accesstoken) throws Exception;

}
