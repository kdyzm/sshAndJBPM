package com.kdyzm.dao.impl;

import org.springframework.stereotype.Repository;

import com.kdyzm.dao.KynamicDao;
import com.kdyzm.dao.base.impl.BaseDaoImpl;
import com.kdyzm.domain.Kynamic;
@Repository("kynamicDao")
public class KynamicDaoImpl extends BaseDaoImpl<Kynamic> implements KynamicDao<Kynamic>{

}
