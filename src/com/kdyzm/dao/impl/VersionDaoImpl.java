package com.kdyzm.dao.impl;

import org.springframework.stereotype.Repository;

import com.kdyzm.dao.VersionDao;
import com.kdyzm.dao.base.impl.BaseDaoImpl;
import com.kdyzm.domain.Version;
@Repository("versionDao")
public class VersionDaoImpl extends BaseDaoImpl<Version> implements VersionDao<Version>{

}
