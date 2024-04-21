package ru.danilakondr.taskplanner.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.danilakondr.taskplanner.model.Task;

@Service
public class TaskServiceImpl implements TaskService {
	private TaskAccessor dao = new TaskAccessorImpl();

	@Autowired
	public void setAccessor(TaskAccessor accessor) {
		this.dao = accessor;
	}
	
	@Override
	public List<Task> allTasks() {
		return dao.allTasks();
	}

	@Override
	public void add(Task task) {
		dao.add(task);
	}

	@Override
	public void delete(Task task) {
		dao.delete(task);
	}

	@Override
	public void edit(Task task) {
		dao.edit(task);
	}

	@Override
	public Task getById(long id) {
		return dao.getById(id);
	}

}
