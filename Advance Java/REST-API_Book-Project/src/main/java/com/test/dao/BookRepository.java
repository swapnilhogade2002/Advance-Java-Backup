package com.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.test.entity.Books;

public interface BookRepository extends CrudRepository<Books, Integer> {
	public Books findById(int id);
}
