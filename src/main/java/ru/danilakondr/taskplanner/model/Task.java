package ru.danilakondr.taskplanner.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name="tasks")
public class Task {
	public static enum Priority {
		NONE, LOW, MEDIUM, HIGH, URGENT
	};
	
	public static enum State {
		HELD, TAKEN, IN_PROGRESS, COMPLETED
	};
	
	@Id
	@Column(name="TaskID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="TimeInHours")
	private int timeInHours;
	
	@Column(name="Priority")
	private Priority priority;
	
	@Column(name="DateOfStart")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfStart;
	
	@Column(name="DateOfEnd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfEnd;
	
	@Column(name="State")
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
