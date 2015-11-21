package com.kdyzm.dao;

import com.kdyzm.dao.base.BaseDao;
import com.kdyzm.domain.Post;

public interface PostDao<T> extends BaseDao<T>{

	Post getPostByName(String string);

}
