package com.taskMngApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskMngApp.dao.TaskRepo;
import com.taskMngApp.model.Task;

@Service
public class TaskService {
	@Autowired
	private TaskRepo taskRepo;
	
	public Task createTask(Task task) {
		return taskRepo.save(task);
	}
	
	public List<Task> getAllTask() {
		return taskRepo.findAll();
	}
	
	public Task getTaskById(Long id) {
		return taskRepo.findById(id).orElse(null);
	}
	
	public Task updateTask(Long id, Task updatedTask) {
		Task task=getTaskById(id);
		if(task!=null)
		{
			task.setTitle(updatedTask.getTitle());
			task.setProject(updatedTask.getProject());
			task.setDueDate(updatedTask.getDueDate());
			task.setPriority(updatedTask.getPriority());
			task.setStatus(updatedTask.getStatus());
			
			return taskRepo.save(task);
		}
		return null;
	}
	
	public void deleteTask(Long id) {
		taskRepo.deleteById(id);
	}
}
