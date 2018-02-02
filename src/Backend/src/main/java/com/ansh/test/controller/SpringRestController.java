package com.ansh.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ansh.test.repository.Department;
import com.ansh.test.repository.TaskList;
import com.ansh.test.repository.TaskResponse;
import com.ansh.test.service.Task;
import com.ansh.test.service.UserService;

@RestController
public class SpringRestController {
	
	Logger log = LoggerFactory.getLogger(SpringRestController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(name="/home", method=RequestMethod.GET) 
	public String home (){
		return "index";
	}
	
	@RequestMapping("/hello")
	public String sayHello(@RequestParam String name, @RequestParam(required=false) String lastName) {
		return "Hello " + name + " " + lastName;
	}
	
	@RequestMapping("/allUsers")
	public List<String> getAllUsers() {
		log.info("All Users invoked");
		return userService.getAllUsers();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addUser", consumes = "application/json")
	public String addUser(@RequestBody(required=false) Task task) {
		return "Task added Successfully : " +task.getTaskName();
	}
	
	@RequestMapping("/allDepartments")
	public List<Department> getAllDepartments() {
		log.info("All Users invoked");
		return userService.getAllDepartments();
	}
	
	@RequestMapping("/tasks")
	public TaskResponse getAllTasks() {
		
		TaskResponse response = new TaskResponse();
		response.setTaskList(userService.getAllTasks());
		return response;
	}
	
	public String toUpperCase(String input) {
		return input.toUpperCase();
	}
}
