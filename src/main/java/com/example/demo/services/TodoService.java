package com.example.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.SubCategoryBo;
import com.example.demo.model.SubCategoryPayload;
import com.example.demo.model.Todo;

public interface TodoService {
	public Todo getTodoById(int id);
	public List<Todo> getAllTodo();
	public ResponseEntity<SubCategoryBo> addSubCategory(SubCategoryPayload payload);
}
