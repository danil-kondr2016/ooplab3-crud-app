package ru.danilakondr.taskplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.fasterxml.jackson.databind.ObjectMapper;

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
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tasks");
		
		mv.addObject("taskList", tasks);

		return mv;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editPage(@PathVariable("id") long id) {
		Task task = service.getById(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("edit");
		mv.addObject("task", task);
		
		return mv;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteTask(@PathVariable("id") long id) {
		Task task = service.getById(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		service.delete(task);
		
		return mv;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public ModelAndView editTask(@ModelAttribute("task") Task task) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		service.edit(task);

		return mv;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("edit");
		
		return mv;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addTask(@ModelAttribute("task") Task task) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		service.add(task);
		
		return mv;
	}
	
	@RequestMapping(value="/json/list", method=RequestMethod.GET)
	public ModelAndView jsonList() {
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setExtractValueFromSingleKeyModel(true);
		
		ModelAndView mv = new ModelAndView();
		mv.setView(view);
		mv.addObject("jsonKey", service.allTasks());
		
		return mv;
	}
	
	@RequestMapping(value="/json/add", method=RequestMethod.POST)
	public ModelAndView jsonAdd(@RequestBody Task task) {
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		ModelAndView mv = new ModelAndView();
		mv.setView(view);
		
		try {
			service.add(task);
			mv.addObject("status", "success");
		}
		catch (IllegalArgumentException e) {
			mv.addObject("status", "failed");
			mv.addObject("reason", e.getMessage());
		}
		
		return mv;
	}
	
	@RequestMapping(value="/json/edit", method=RequestMethod.POST)
	public ModelAndView jsonEdit(@RequestBody Task task) {
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		ModelAndView mv = new ModelAndView();
		mv.setView(view);
		
		try {
			service.edit(task);
			mv.addObject("status", "success");
		}
		catch (IllegalArgumentException e) {
			mv.addObject("status", "failed");
			mv.addObject("reason", e.getMessage());
		}
		
		return mv;
	}
	
	@RequestMapping(value="/json/delete/{id}", method=RequestMethod.GET)
	public ModelAndView jsonDelete(@PathVariable("id") long id) {
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		ModelAndView mv = new ModelAndView();
		mv.setView(view);
		
		try {
			Task task = service.getById(id);
			service.delete(task);
		}
		catch (IllegalArgumentException e) {
			mv.addObject("status", "failed");
			mv.addObject("reason", e.getMessage());
		}
		
		return mv;
	}
}
