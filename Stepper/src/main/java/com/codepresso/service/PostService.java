package com.codepresso.service;

import com.codepresso.domain.PostVO;
import com.codepresso.domain.ResponseData;

public interface PostService {

	public ResponseData savePost(PostVO postVO, String accesstoken);

	public ResponseData findAllPost(String accesstoken);

	public ResponseData findMyPost(String accesstoken);

	public ResponseData postDetailById(Long id);

	public ResponseData deletePostById(Long id);

	public ResponseData viewMyFeedList(String accesstoken);

}
