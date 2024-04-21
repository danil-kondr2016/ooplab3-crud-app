package ru.danilakondr.taskplanner.dao;

import java.util.List;

import ru.danilakondr.taskplanner.model.Task;

public class TaskServiceImpl implements TaskService {
	private TaskAccessor dao = new TaskAccessorImpl();

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
