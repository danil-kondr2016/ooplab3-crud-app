package ru.danilakondr.taskplanner.dao;

import java.util.List;

import ru.danilakondr.taskplanner.model.Task;

public interface TaskService {
	List<Task> allTasks();
	
	void add(Task task);
	void delete(Task task);
	void edit(Task task);
	
	Task getById(long id);
}
