package bs.fatec.ToDo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface ControllerInterface<T> {
   ResponseEntity<List<T>> getAll();
   ResponseEntity<?> get(Long id);
   ResponseEntity<T> post(T obj);
   ResponseEntity<?> put(Long id, T obj);
   ResponseEntity<?> patch(Long id, Map<String, Object> updates);
   ResponseEntity<?> delete(Long id);
}