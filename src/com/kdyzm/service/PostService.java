package com.kdyzm.service;

import com.kdyzm.domain.Post;

public interface PostService {

	void savePost(Post post1);

	Post getPostByName(String string);

}
