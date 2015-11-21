package com.kdyzm.dao.impl;

import org.springframework.stereotype.Repository;

import com.kdyzm.dao.ApproveDao;
import com.kdyzm.dao.base.impl.BaseDaoImpl;
import com.kdyzm.domain.Approve;
@Repository("approveDao")
public class ApproveDaoImpl extends BaseDaoImpl<Approve> implements ApproveDao<Approve>{
	
}
