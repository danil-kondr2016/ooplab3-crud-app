package ru.danilakondr.taskplanner.model;

import java.time.LocalDate;

public class Task {
	public static enum Priority {
		NONE, LOW, MEDIUM, HIGH, URGENT
	};
	
	public static enum State {
		HELD, TAKEN, IN_PROGRESS, COMPLETED
	};
	
	private long id;
	private String taskName;
	private int timeInHours;
	private Priority priority;
	private LocalDate dateOfStart;
	private LocalDate dateOfEnd;
	private State taskState;
	
	public Task() {
		
	}
	
	public String toString() {
		return String.format("Task %d: %s, %d hours, priority %s, started at %s, state %s",
				id, taskName, timeInHours, priority, dateOfStart, taskState);
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public int getTimeInHours() {
		return timeInHours;
	}
	
	public void setTimeInHours(int timeInHours) {
		this.timeInHours = timeInHours;
	}
	
	public Priority getPriority() {
		return priority;
	}
	
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	public LocalDate getDateOfStart() {
		return dateOfStart;
	}
	
	public void setDateOfStart(LocalDate date) {
		this.dateOfStart = date;
	}	
	
	public void setDateOfStart(int year, int month, int day) {
		this.dateOfStart = LocalDate.of(year, month, day);
	}
	
	public LocalDate getDateOfEnd() {
		return dateOfEnd;
	}
	
	public void setDateOfEnd(LocalDate date) {
		this.dateOfEnd = date;
	}
	
	public void setDateOfEnd(int year, int month, int day) {
		this.dateOfEnd = LocalDate.of(year, month, day);
	}
	
	public State getTaskState() {
		return taskState;
	}
	
	public void setTaskState(State state) {
		this.taskState = state;
	}
}
