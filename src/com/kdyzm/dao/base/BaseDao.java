package com.kdyzm.dao.base;

import java.io.Serializable;
import java.util.Collection;

public interface BaseDao<T>{
	public Collection<T> getAllEntry();
	public T getEntryById(Serializable id);
	public void saveEntry(T t);
	public void deleteEntry(T t);
	public void updateEntry(T t);
}
