package com.taskMngApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskMngApp.model.Project;
import com.taskMngApp.model.Task;
import com.taskMngApp.service.ProjectService;
import com.taskMngApp.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private TaskService taskService;
	@Autowired
	private ProjectService projectService;
	
	@PostMapping
	public Task createTask(@RequestBody Task task) {
		Project project = task.getProject();
        Project savedProject = projectService.saveProject(project);
        task.setProject(savedProject);
		return taskService.createTask(task);
	}
	
	@GetMapping("/{id}")
	public Task getTaskById(@PathVariable Long id) {
		return taskService.getTaskById(id);
	}
	
	@GetMapping
	public List<Task> getAllTasks(){
		return taskService.getAllTask();
	}
	
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
	}
	
	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
		return taskService.updateTask(id, updatedTask);
	}
}
