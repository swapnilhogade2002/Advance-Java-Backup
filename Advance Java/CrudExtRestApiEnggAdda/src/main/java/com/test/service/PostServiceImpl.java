package com.test.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.model.Todo;

@Service
public class PostServiceImpl implements PostService {

	private final String apiUrl = "https://jsonplaceholder.typicode.com/todos";
	private final RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

	public PostServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public List<Todo> showData() {
		logger.info("Retrieving all todos");
		return Arrays.asList(restTemplate.getForObject(apiUrl, Todo[].class));
	}

	@Override
	public Todo showParticularData(int taskId) {
		String url = apiUrl + "/" + taskId;
		logger.info("Retrieving todo for taskId: {}", taskId);
		return restTemplate.getForObject(url, Todo.class);
	}

	@Override
	public void createNewData(Todo todo) {
		logger.info("Creating new todo: {}", todo);
		restTemplate.postForObject(apiUrl, todo, Todo.class);
	}

	@Override
	public void updateData(int taskId, Todo todo) {
		String url = apiUrl + "/" + taskId;
		logger.info("Updating todo for taskId: {} with data: {}", taskId, todo);
		restTemplate.put(url, todo);
	}

	@Override
	public void deleteData(int taskId) {
		String url = apiUrl + "/" + taskId;
		logger.info("Deleting todo for taskId: {}", taskId);
		restTemplate.delete(url);
	}

	@Override
	public List<Todo> searchByTitle(String title) {
		logger.info("Searching todos by title: {}", title);

		// Fetch all todos
		Todo[] allTodos = restTemplate.getForObject(apiUrl, Todo[].class);

		// Filter todos based on the search parameter
		List<Todo> matchingTodos = Arrays.stream(allTodos).filter(
				todo -> todo.getTitle() != null && todo.getTitle().toLowerCase().startsWith(title.toLowerCase()))
				.collect(Collectors.toList());

		return matchingTodos;
	}

}

//@Service
//public class PostServiceImpl implements PostService {
//
//	String baseUrl = "https://jsonplaceholder.typicode.com/";
//	StringBuilder stringBuilder = new StringBuilder(baseUrl);
//
//	String POST = "/posts";
//	@Autowired
//	private RestTemplate restTemplate;
//
//	@Override
//	public List<Map<String, Object>> getPosts() {
//		HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());
//		String url = stringBuilder.append(POST).toString();
//
//		ParameterizedTypeReference<List<Map<String, Object>>> responseType = new ParameterizedTypeReference<List<Map<String, Object>>>() {
//		};
//
//		ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
//				responseType);
//		return response.getBody();
//	}
//
//	private HttpHeaders getHttpHeaders() {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		return headers;
//
//	}
//
//}
