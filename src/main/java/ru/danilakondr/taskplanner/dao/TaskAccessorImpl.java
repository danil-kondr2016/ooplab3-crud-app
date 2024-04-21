package ru.danilakondr.taskplanner.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.danilakondr.taskplanner.model.Task;

@Repository
public class TaskAccessorImpl implements TaskAccessor {
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Task> allTasks() {
		Session session = sessionFactory.getCurrentSession();
		return session.createSelectionQuery("FROM Task", Task.class).getResultList();
	}

	@Override
	public void add(Task task) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(task);
	}

	@Override
	public void delete(Task task) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(task);
	}

	@Override
	public void edit(Task task) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(task);
	}

	@Override
	public Task getById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Task.class, id);
	}
}
