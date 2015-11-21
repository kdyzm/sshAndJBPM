package com.kdyzm.dao.base.impl;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.kdyzm.dao.base.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T>{

	//泛型的真实类型
	private Class<T> clazz;
	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
	
	public BaseDaoImpl() {
		//在默认构造方法中得到真实的类型
		//ParameterizedType就是泛型
		ParameterizedType pt=(ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz=(Class) pt.getActualTypeArguments()[0];//得到实际的参数类型，<T>
//		System.out.println(clazz.getSimpleName());
//		System.out.println(pt.getRawType());//打印声明该方法的类或者接口类型，BaseServiceImpl
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public Collection<T> getAllEntry() {
		Collection<T> collection= this.hibernateTemplate.find("from "+clazz.getName());
		return collection;
	}

	@Override
	public T getEntryById(Serializable id) {
		return (T) this.hibernateTemplate.get(clazz, id);
	}

	@Override
	@Transactional(readOnly=false)
	public void saveEntry(T t) {
		this.hibernateTemplate.save(t);
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteEntry(T t) {
		this.hibernateTemplate.delete(t);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateEntry(T t) {
		this.hibernateTemplate.update(t);
	}
}
