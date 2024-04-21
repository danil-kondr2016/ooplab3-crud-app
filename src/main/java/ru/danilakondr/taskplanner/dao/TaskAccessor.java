package ru.danilakondr.taskplanner.dao;

import ru.danilakondr.taskplanner.model.Task;
import java.util.List;

public interface TaskAccessor {
	List<Task> allTasks();
	
	void add(Task task);
	void delete(Task task);
	void edit(Task task);
	
	Task getById(long id);
}
