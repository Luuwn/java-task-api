package bs.fatec.ToDo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import bs.fatec.ToDo.model.Task;
import bs.fatec.ToDo.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
    private TaskService service;

    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> get(@PathVariable("id") Long id) {
    	Task _task = service.findById(id);
        if (_task != null)
            return ResponseEntity.ok(_task);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Task> post(@RequestBody Task task) {
        service.create(task);
        URI location=ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(location).body(task);
    }
    
    //@PutMapping(value = "/{id}")
    //public ResponseEntity<Task> put(@RequestBody Task updatedTask) {
    //   System.out.println("Received PUT request for Task ID: " );
    //	if (service.update(updatedTask)) {
    //        return ResponseEntity.ok(updatedTask);
    //    }
    //   return ResponseEntity.notFound().build();
    //}
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Task> put(@PathVariable("id") Long id, @RequestBody Task task){
    	Task updTask = service.update(id, task);
        return ResponseEntity.ok().body(updTask);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

