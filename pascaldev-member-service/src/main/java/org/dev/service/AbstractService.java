package org.dev.service;

import java.util.List;

public interface AbstractService <T>{
	
	 T save(T t);

	    T update(T t);

	    T findById(Long id);

	    List<T> findAll();

	    void delete(Long id);

}
