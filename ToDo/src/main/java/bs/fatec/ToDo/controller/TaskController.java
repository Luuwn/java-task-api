package bs.fatec.ToDo.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import bs.fatec.ToDo.model.Task;
import bs.fatec.ToDo.service.TaskService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/tasks")
public class TaskController implements ControllerInterface<Task>{

    @Autowired
    private TaskService service;

    // GET ALL
    @GetMapping(produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a lista de Tasks"),
            @ApiResponse(responseCode = "500", description = "Erro interno do sistema"), })
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // GET
    @GetMapping(value = "/{id}", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task pelo id"),
            @ApiResponse(responseCode = "404", description = "Task não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do sistema"), })
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        Task _task = service.findById(id);
        if (_task != null)
            return ResponseEntity.ok(_task);
        return ResponseEntity.notFound().build();
    }

    // POST
    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Task criada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do sistema"), })
    public ResponseEntity<Task> post(@RequestBody Task task) {
        service.create(task);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(task.getId())
                .toUri();
        return ResponseEntity.created(location).body(task);
    }

    // PUT
    @PutMapping(produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task atualizada"),
            @ApiResponse(responseCode = "404", description = "Task não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do sistema"), })
    public ResponseEntity<?> put(@RequestBody Task task) {
        if (service.update(task)) {
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.notFound().build();
    }

    // PATCH
    @PatchMapping(value = "/{id}", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Campo da task atualizado"),
            @ApiResponse(responseCode = "404", description = "Campo da task  não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do sistema"), })
    public ResponseEntity<Task> patch(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates) {
        if (service.patch(id, updates)) {
            return ResponseEntity.ok(service.findById(id));
        }
        return ResponseEntity.notFound().build();
    }
 
    // DELETE
    @DeleteMapping(value = "/{id}", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task excluí­da"),
            @ApiResponse(responseCode = "404", description = "Task não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do sistema"), })
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}