package bs.fatec.ToDo.service;

import java.util.List;
import java.util.Map;

public interface ServiceInterface<T> {
	T create(T obj);

	T findById(Long id);

	List<T> findAll();

	boolean update(Long id, T obj);

	boolean patch(Long id, Map<String, Object> updates);

	boolean delete(Long id);
}