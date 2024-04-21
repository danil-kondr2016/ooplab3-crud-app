package ru.danilakondr.taskplanner.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import ru.danilakondr.taskplanner.model.Task;

public class TaskAccessorImpl implements TaskAccessor {
	private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
	private static Map<Long, Task> data = new HashMap<>();
	
	static {
		Task t1 = new Task();
		t1.setId(1);
		t1.setTaskName("Task #1");
		t1.setPriority(Task.Priority.HIGH);
		t1.setTimeInHours(40);
		t1.setDateOfStart(2024, 4, 21);
		t1.setTaskState(Task.State.IN_PROGRESS);
		
		data.put(t1.getId(), t1);
		
		Task t2 = new Task();
		t2.setId(2);
		t2.setTaskName("Task #2");
		t2.setPriority(Task.Priority.HIGH);
		t2.setTimeInHours(30);
		t2.setDateOfStart(2024, 4, 21);
		t2.setTaskState(Task.State.HELD);
		
		data.put(t2.getId(), t2);
	}
	
	@Override
	public List<Task> allTasks() {
		return new ArrayList<>(data.values());
	}

	@Override
	public void add(Task task) {
		task.setId(AUTO_ID.incrementAndGet());
		data.put(task.getId(), task);
	}

	@Override
	public void delete(Task task) {
		data.remove(task.getId());
	}

	@Override
	public void edit(Task task) {
		data.put(task.getId(), task);
	}

	@Override
	public Task getById(long id) {
		return data.get(id);
	}
}
