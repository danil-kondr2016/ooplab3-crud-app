package ru.danilakondr.taskplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ru.danilakondr.taskplanner.model.Task;

@Controller
public class TaskPlannerController {
	
	private Task createTask(long id) {
		Task t = new Task();
		
		t.setId(id);
		t.setPriority(Task.Priority.URGENT);
		t.setTaskName("Test");
		t.setTimeInHours(40);
		t.setTaskState(Task.State.IN_PROGRESS);
		t.setDateOfStart(2024, 4, 21);
		
		return t;
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView allTasks() {
		ModelAndView mw = new ModelAndView();
		mw.setViewName("tasks");
		
		Task t = createTask(1000);
		mw.addObject("task", t);
		
		return mw;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView editPage() {
		ModelAndView mw = new ModelAndView();
		mw.setViewName("edit");
		return mw;
	}

}
