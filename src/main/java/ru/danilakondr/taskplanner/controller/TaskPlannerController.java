package ru.danilakondr.taskplanner.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ru.danilakondr.taskplanner.model.Task;
import ru.danilakondr.taskplanner.dao.*;

@Controller
public class TaskPlannerController {
	private TaskService service;
	
	@Autowired
	public void setService(TaskService service) {
		this.service = service;
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView allTasks() {
		List<Task> tasks = service.allTasks();
		
		ModelAndView mw = new ModelAndView();
		mw.setViewName("tasks");
		
		mw.addObject("taskList", tasks);
		
		return mw;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editPage(@PathVariable("id") long id) {
		Task task = service.getById(id);
		
		ModelAndView mw = new ModelAndView();
		mw.setViewName("edit");
		mw.addObject("task", task);
		
		return mw;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public ModelAndView editTask(@ModelAttribute("task") Task task) {
		ModelAndView mw = new ModelAndView();
		mw.setViewName("redirect:/");
		service.edit(task);
		
		return mw;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addPage() {
		ModelAndView mw = new ModelAndView();
		mw.setViewName("edit");
		
		return mw;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addTask(@ModelAttribute("task") Task task) {
		ModelAndView mw = new ModelAndView();
		mw.setViewName("redirect:/");
		service.add(task);
		
		return mw;
	}
}
