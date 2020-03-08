package com.codepresso.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codepresso.domain.PostVO;
import com.codepresso.domain.ResponseData;
import com.codepresso.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

	private static final Logger logger = LoggerFactory.getLogger(PostController.class);

	@Autowired
	private PostService postService;

	@PostMapping("")
	public ResponseData savePost(@RequestBody PostVO postVO,
			@CookieValue(value = "accesstoken", required = false) String accesstoken) throws Exception {
		logger.info("call savePost() method in PostController");
		return postService.savePost(postVO, accesstoken);
	}

	@GetMapping("")
	public ResponseData findAllPost(@CookieValue(value = "accesstoken", required = false) String accesstoken)
			throws Exception {
		logger.info("call findAllPost() method in PostController");
		return postService.findAllPost(accesstoken);
	}

	@GetMapping("/my")
	public ResponseData findMyPost(@CookieValue(value = "accesstoken", required = false) String accesstoken)
			throws Exception {
		logger.info("call findMyPost() method in PostController");
		return postService.findMyPost(accesstoken);
	}

	@GetMapping("/{postId}")
	public ResponseData postDetailById(@PathVariable("postId") Long id) throws Exception {
		logger.info("call postDetailById() method in PostController");
		return postService.postDetailById(id);
	}

	@DeleteMapping("/{postId}")
	public ResponseData deletePost(@PathVariable("postId") Long id) throws Exception {
		logger.info("call deletePost() method in PostController");
		return postService.deletePostById(id);
	}

	@GetMapping("/feed")
	public ResponseData viewMyFeedList(@CookieValue(value = "accesstoken", required = false) String accesstoken)
			throws Exception {
		logger.info("call viewMyFeedList()");
		return postService.viewMyFeedList(accesstoken);
	}

}
