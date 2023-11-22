package bs.fatec.ToDo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	
	public Task update(Long id, Task task) {
		Task _task = findById(id);
		_task.setTitle(task.getTitle());
		_task.setDescription(task.getDescription());
		_task.setStatus(task.getStatus());
		_task.setDueDate(task.getDueDate());
		_task.setPriority(task.getPriority());
		return _task;
	}
	
	public boolean patch(Long id, Map<String, Object> updates) {
	    Task taskToUpdate = findById(id);
	    if (taskToUpdate != null) {
	        updates.forEach((key, value) -> {
	            switch (key) {
	                case "title":
	                    taskToUpdate.setTitle((String) value);
	                    break;
	                case "description":
	                    taskToUpdate.setDescription((String) value);
	                    break;
	                case "status":
	                    taskToUpdate.setStatus(Task.Status.valueOf((String) value));
	                    break;
	                case "dueDate":
	                    taskToUpdate.setDueDate(LocalDate.parse((String) value));
	                    break;
	                case "priority":
	                    taskToUpdate.setPriority(Task.Priority.valueOf((String) value));
	                    break;
	            }
	        });
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
