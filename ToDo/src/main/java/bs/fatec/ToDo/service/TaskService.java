package bs.fatec.ToDo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import bs.fatec.ToDo.model.Task;

@Service
public class TaskService {
	private static List<Task> tasks = new ArrayList<>();
	
	public TaskService(){};
	public void create(Task task) {
		task.setId(task.generateId());
		tasks.add(task);
	}
	
	public List<Task> findAll(){
		return tasks;
	}
	
	public Task findById(Long id) {
	    for (Task t : tasks) {
	        if (t.getId().equals(id)) {
	            return t;
	        }
	    }
	    return null;
	}
	
	//public Task findByTask(Task task) {
	//	for(Task t : tasks) {
	//		if (t.equals(task)) {
	//			return t;
	//		}
	//	}
	//	return null;
	//}
	
	public Task update(Long id, Task task) {
		Task _task = findById(id);
		//if (task != null) {
		_task.setTitle(task.getTitle());
		_task.setDescription(task.getDescription());
		_task.setStatus(task.getStatus());
		_task.setDueDate(task.getDueDate());
		_task.setPriority(task.getPriority());
		return _task;
			
		//}
	}
	
	public boolean update(Task task) {
		//Long id = task.getId();
		//Task _task = findById(id);
		if (task != null) {
			task.setTitle(task.getTitle());
			task.setDescription(task.getDescription());
			task.setStatus(task.getStatus());
			task.setDueDate(task.getDueDate());
			task.setPriority(task.getPriority());
			return true;
			
		}
		return false;
	}
	
	public boolean delete(Long id) {
		Task _task = findById(id);
		if (_task != null) {
			tasks.remove(_task);
			return true;
		}
		return false;
	}

	

	
}
