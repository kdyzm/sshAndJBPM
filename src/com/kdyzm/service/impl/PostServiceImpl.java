package com.kdyzm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kdyzm.dao.PostDao;
import com.kdyzm.domain.Post;
import com.kdyzm.service.PostService;
@Service("postService")
public class PostServiceImpl implements PostService{
	@Resource(name="postDao")
	private PostDao<Post> postDao;
	
	@Override
	public void savePost(Post post1) {
		postDao.saveEntry(post1);
	}

	@Override
	public Post getPostByName(String string) {
		return postDao.getPostByName(string);
	}

}
