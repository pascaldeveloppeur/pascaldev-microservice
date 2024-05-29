package com.pascaldev.Student.Service;

import java.util.List;

public interface BaseStudentService<T> {
	
	  T  save(T t);
      List<T> findAll();
      T findById(Long id);
      T update(Long id,T t);
      void deleteById(Long id);

}
