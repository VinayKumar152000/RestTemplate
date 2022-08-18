package com.example.demo.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SubCategoryBo;
import com.example.demo.model.SubCategoryPayload;
import com.example.demo.model.Todo;
import com.example.demo.services.TodoService;

@RestController
@RequestMapping("/api")
public class TodoController {
	
	@Autowired
	private TodoService service;
	
	@GetMapping
	public List<Todo> getAllTodo(){
		return service.getAllTodo();
	}

	@GetMapping("/{id}")
	public Todo getTodoById(@PathVariable int id) {
		return service.getTodoById(id);
	}
	
	@PostMapping
	public ResponseEntity<SubCategoryBo> addSubCategory(@RequestBody SubCategoryPayload payload) {
		return service.addSubCategory(payload);
	}
}
