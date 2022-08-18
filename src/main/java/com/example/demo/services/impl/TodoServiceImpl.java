package com.example.demo.services.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.SubCategoryBo;
import com.example.demo.model.SubCategoryPayload;
import com.example.demo.model.Todo;
import com.example.demo.services.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private RestTemplate restTemplate;

	final String ROOT_URI = "https://jsonplaceholder.typicode.com/todos";

	public Todo getTodoById(int id) {

		Todo todo = restTemplate.getForObject(ROOT_URI + "/" + id, Todo.class);
		return todo;
	}

	public List<Todo> getAllTodo() {
		Todo[] list = restTemplate.getForObject(ROOT_URI, Todo[].class);
		//getforentity to get reponsse at entity of a class

		return Arrays.asList(list);
	}

	//https://reflectoring.io/spring-resttemplate/
	public ResponseEntity<SubCategoryBo> addSubCategory(SubCategoryPayload payload) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		URI uri = null;
		try {
			uri = new URI("http://localhost:8081/api/subcategories");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpEntity<SubCategoryPayload> httpEntity = new HttpEntity<>(payload, headers);
//		SubCategoryBo todo = restTemplate.postForObject(uri, httpEntity, SubCategoryBo.class);
		
		 ResponseEntity<SubCategoryBo> todo = restTemplate.execute(uri, HttpMethod.POST, null, null);
//		ResponseEntity<SubCategoryBo> todo = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, SubCategoryBo.class);
		return todo;
	}
}
