package ru.danilakondr.taskplanner.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.danilakondr.taskplanner.model.Task;

@Service
public class TaskServiceImpl implements TaskService {
	private TaskAccessor accessor = new TaskAccessorImpl();

	@Autowired
	public void setAccessor(TaskAccessor accessor) {
		this.accessor = accessor;
	}
	
	@Override
	@Transactional
	public List<Task> allTasks() {
		return accessor.allTasks();
	}

	@Override
	@Transactional
	public void add(Task task) {
		accessor.add(task);
	}

	@Override
	@Transactional
	public void delete(Task task) {
		accessor.delete(task);
	}

	@Override
	@Transactional
	public void edit(Task task) {
		accessor.edit(task);
	}

	@Override
	@Transactional
	public Task getById(long id) {
		return accessor.getById(id);
	}

}
