package com.taskMngApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskMngApp.model.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {

}
