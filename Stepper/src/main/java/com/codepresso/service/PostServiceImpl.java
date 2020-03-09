package com.codepresso.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.codepresso.domain.FeedVO;
import com.codepresso.domain.FollowVO;
import com.codepresso.domain.PostAndUserVO;
import com.codepresso.domain.PostVO;
import com.codepresso.domain.ResponseData;
import com.codepresso.domain.TokenVO;
import com.codepresso.domain.UserVO;
import com.codepresso.repository.FeedDAO;
import com.codepresso.repository.FollowDAO;
import com.codepresso.repository.PostDAO;
import com.codepresso.repository.UserDAO;

@Service
public class PostServiceImpl implements PostService{
	
	private static final Logger logger = LoggerFactory.getLogger(PostService.class);

	@Autowired
	private PostDAO postDAO;

	@Autowired
	ResponseData responseData;

	@Autowired
	TokenVO tokenVO;

	@Autowired
	UserService userService;

	@Autowired
	PostVO postVO;

	@Autowired
	UserVO userVO;

	@Autowired
	UserDAO userDAO;

	@Autowired
	FollowVO followVO;

	@Autowired
	FollowDAO followDAO;

	@Autowired
	FeedVO feedVO;

	@Autowired
	FeedDAO feedDAO;

	@Override
	public ResponseData savePost(PostVO postVO, String accesstoken) throws Exception {

		TokenVO userByToken = userDAO.viewUserByToken(accesstoken);
		logger.info("user by Token: " + userByToken);

		Long userId = userByToken.getUserId();
		postVO.setUserId(userId);
		logger.info("postVO: " + postVO);

		postDAO.savePost(postVO);

		Long id = postVO.getId();
		PostVO result = postDAO.findPostById(id);

		followVO.setFolloweeId(userId);
		List<FollowVO> findFollowers = followDAO.findFollowersByFollowee(userId);

		for (int j = 0; j < findFollowers.size(); j++) {
			feedVO.setUserId(findFollowers.get(j).getFollowerId());
			feedVO.setFolloweeId(userId);
			feedVO.setPostId(id);
			feedDAO.insertFeed(feedVO);
		}

		responseData.setCode(HttpStatus.OK);
		responseData.setMessage("SUCCESS");
		responseData.setData(result);

		return responseData;
	}

	@Override
	public ResponseData findAllPost(String accesstoken) throws Exception {
		logger.info("call findAllPost() method in PostServiceImpl");
		List<PostAndUserVO> postList = postDAO.findAllPost();
		logger.info("postList.size: " + postList.size());
		logger.info("postList: " + postList.toString());
		if (accesstoken != null) {

			TokenVO userByToken = userDAO.viewUserByToken(accesstoken);
			logger.info("user by token: " + userByToken);

			Long userId = userByToken.getUserId();
			logger.info("user id: " + userId);

			List<FeedVO> followees = feedDAO.findFolloweeByUser(userId);
			logger.info("followees.size: " + followees.size());

			ArrayList<Long> postUser = new ArrayList<Long>(postList.size());
			ArrayList<Long> followeeList = new ArrayList<Long>(followees.size());

			for (int i = 0; i < postList.size(); i++) {
				postUser.add(postList.get(i).getUserId());

			}

			for (int j = 0; j < followees.size(); j++) {
				followeeList.add(followees.get(j).getFolloweeId());
			}

			int i = 0;
			for (Long postUserId : postUser) {
				boolean isFollow = false;
				for (Long followeeId : followeeList) {

					if (postUserId.equals(followeeId)) {
						isFollow = true;
						break;
					} else {
						isFollow = false;
					}
				}
				postList.get(i).getUser().setIsFollow(isFollow);
				i++;
			}

			responseData.setCode(HttpStatus.OK);
			responseData.setMessage("SUCCESS");
			responseData.setData(postList);
			return responseData;
		} else {
			responseData.setCode(HttpStatus.OK);
			responseData.setMessage("SUCCESS");
			responseData.setData(postList);
			return responseData;

		}
	}

	@Override
	public ResponseData findMyPost(String accesstoken) throws Exception {
		logger.info("call findMyPost() method in PostServiceImpl");

		TokenVO userByToken = userDAO.viewUserByToken(accesstoken);
		logger.info("user by Token: " + userByToken);

		Long userId = userByToken.getUserId();
		logger.info("user id: " + userId);

		List<PostAndUserVO> myPostList = postDAO.findMyPost(userId);
		logger.info("myPostList: " + myPostList);

		responseData.setCode(HttpStatus.OK);
		responseData.setMessage("SUCCESS");
		responseData.setData(myPostList);

		return responseData;
	}

	@Override
	public ResponseData postDetailById(Long id) throws Exception {
		logger.info("call postDetailById() method in PostServiceImpl");

		PostAndUserVO postDetail = postDAO.postDetailById(id);

		responseData.setCode(HttpStatus.OK);
		responseData.setMessage("SUCCESS");
		responseData.setData(postDetail);

		return responseData;
	}

	@Override
	public ResponseData deletePostById(Long id) throws Exception {
		logger.info("call deletePostById() method in PostServiceImpl");

		int result = postDAO.deletePostById(id);
		logger.info("result: " + result);

		int feedResult = feedDAO.deleteFeedByPostId(id);
		logger.info("feedResult :" + feedResult);

		if (result == 1) {
			responseData.setCode(HttpStatus.OK);
			responseData.setMessage("SUCCESS");
			responseData.setData(null);
		} else {
			responseData.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
			responseData.setMessage("ERROR");
			responseData.setData(null);
		}

		return responseData;
	}
	
	@Override
	public ResponseData viewMyFeedList(String accesstoken) throws Exception {
		logger.info("call viewMyFeedList()");

		TokenVO followerByToken = userDAO.viewUserByToken(accesstoken);
		logger.info("follower by token: " + followerByToken);

		Long followerId = followerByToken.getUserId();
		logger.info("follower id: " + followerId);

		feedVO.setUserId(followerId);
		logger.info("set followerId in feedVO: " + feedVO);
		
		List<FeedVO> followees = feedDAO.findFolloweeByUser(followerId);
		logger.info("followees list: " + followees);
		
		PostAndUserVO[] followeePostList = new PostAndUserVO[followees.size()];
		for (int i = 0; i < followeePostList.length; i++) {
			PostAndUserVO postAndUserVO = new PostAndUserVO();
			
			Long postId = followees.get(i).getPostId();
			postVO = postDAO.findPostById(postId);
			postAndUserVO.setId(postId);
			Long userId = postVO.getUserId();
			postAndUserVO.setUserId(userId);
			String title = postVO.getTitle();
			postAndUserVO.setTitle(title);
			String content = postVO.getContent();
			postAndUserVO.setContent(content);
			Date createdAt = postVO.getCreatedAt();
			postAndUserVO.setCreatedAt(createdAt);
			userVO = userDAO.findUserById(userId);
			postAndUserVO.setUser(userVO);
			followeePostList[i] = postAndUserVO;
		}
		
		responseData.setCode(HttpStatus.OK);
		responseData.setMessage("SUCCESS");
		responseData.setData(followeePostList);
		logger.info("followee post: " + followeePostList);

		return responseData;

	}

}
