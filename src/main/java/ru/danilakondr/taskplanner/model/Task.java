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
	private String name;
	private int timeInHours;
	private Priority priority;
	private LocalDate dateOfStart;
	private LocalDate dateOfEnd;
	private State state;
	
	public Task() {
		
	}
	
	public String toString() {
		return String.format("Task %d: %s, %d hours, priority %s, started at %s, state %s",
				id, name, timeInHours, priority, dateOfStart, state);
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String taskName) {
		this.name = taskName;
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
	
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
}
