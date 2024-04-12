package com.taskMngApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskMngApp.model.Project;

public interface ProjectRepo extends JpaRepository<Project, Long> {

}
