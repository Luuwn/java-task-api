package bs.fatec.ToDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bs.fatec.ToDo.model.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}