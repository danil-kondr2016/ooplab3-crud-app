package ru.danilakondr.taskplanner.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ru.danilakondr.taskplanner.model.Task;
import ru.danilakondr.taskplanner.dao.*;

@Controller
public class TaskPlannerController {
	private TaskService service = new TaskServiceImpl();

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView allTasks() {
		List<Task> tasks = service.allTasks();
		
		ModelAndView mw = new ModelAndView();
		mw.setViewName("tasks");
		
		mw.addObject("taskList", tasks);
		
		return mw;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView editPage() {
		ModelAndView mw = new ModelAndView();
		mw.setViewName("edit");
		return mw;
	}

}
