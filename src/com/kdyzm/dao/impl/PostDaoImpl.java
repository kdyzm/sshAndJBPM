package com.kdyzm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kdyzm.dao.PostDao;
import com.kdyzm.dao.base.impl.BaseDaoImpl;
import com.kdyzm.domain.Post;
@Repository("postDao")
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao<Post>{

	@Override
	public Post getPostByName(String string) {
		String sql="from Post where pname=?";
		List<Post> list=this.hibernateTemplate.find(sql,string);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

}
