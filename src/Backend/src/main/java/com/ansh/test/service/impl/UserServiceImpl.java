package com.ansh.test.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.ansh.test.dao.UserDao;
import com.ansh.test.repository.Department;
import com.ansh.test.repository.DepartmentRepository;
import com.ansh.test.repository.Task;
import com.ansh.test.repository.TaskList;
import com.ansh.test.repository.TaskRepository;
import com.ansh.test.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	DepartmentRepository repo;
	
	@Autowired
	TaskRepository repo2;
	
	@Autowired
	JdbcTemplate template;
	
	@PostConstruct
	public void init() {
		System.out.println("--------HI--------");
	}
	
	public List<String> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public List<Department> getAllDepartments() {

		return IteratorUtils.toList(repo.findAll().iterator());
	}

	@Override
	public List<TaskList> getAllTasks() {
		return template.query("select * from task_list", new RowMapper<TaskList>() {

			@Override
			public TaskList mapRow(ResultSet rs, int index) throws SQLException {
				TaskList task = new TaskList();
				task.setName(rs.getString("task_name"));
				task.setClazz(rs.getString("task_class"));
				task.setStatus(rs.getString("status"));
				return task;
			}
			
		});
	}
	
	
}
