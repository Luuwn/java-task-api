package bs.fatec.ToDo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bs.fatec.ToDo.model.Task;
import bs.fatec.ToDo.repository.TaskRepository;

@Service
public class TaskService implements ServiceInterface<Task> {

	@Autowired
	private TaskRepository repository;

	public TaskService() {
	};

	@Override
	public Task create(Task obj) {
		repository.save(obj);
		return obj;
	}

	@Override
	public List<Task> findAll() {
		return repository.findAll();
	}

	@Override
	public Task findById(Long id) {
		Optional<Task> obj = repository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public boolean update(Long id, Task obj) {
		if (repository.existsById(id)) {
			obj.setId(id); 
			repository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean patch(Long id, Map<String, Object> updates) {
		Optional<Task> optionalTask = repository.findById(id);
	
		if (optionalTask.isPresent()) {
			Task taskToUpdate = optionalTask.get();
	
			for (Map.Entry<String, Object> entry : updates.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
	
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
			}
			repository.save(taskToUpdate);
			return true;
		}
		return false;
	}
}