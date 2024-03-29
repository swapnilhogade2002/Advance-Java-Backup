package com.test.service;

import java.util.List;

import com.test.model.Todo;

public interface PostService {
	List<Todo> showData();

	List<Todo> searchByTitle(String title);

//	List<Todo> showDataSorted(String sortBy);

	Todo showParticularData(int taskId);

	void createNewData(Todo todo);

	void updateData(int taskId, Todo todo);

	void deleteData(int taskId);
}
