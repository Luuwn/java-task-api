package bs.fatec.ToDo.model;

import java.time.LocalDate;
import java.util.Objects;

public class Task {

	private Long id;
	private String title;
	private String description;
	public enum Status { TODO, IN_PROGRESS, DONE};
	private Status status;
	private LocalDate dueDate;
	public enum Priority {LOW, MEDIUM, HIGH};
	private Priority priority;
	
	private static Long nextId = 1L;
	
	public Task() {}

    public Task(Long id) {  this.id = id; }
	
	public Task(Long id, String title, String description, Status status, LocalDate dueDate, Priority priority) {
	    this.id = id;
	    this.title = title;
	    this.description = description;
	    this.status = status;
	    this.dueDate = dueDate;
	    this.priority = priority;
	}
	
	public Long generateId() {
		return nextId++;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Task other = (Task) obj;
	    return id != null && id.equals(other.id);
	}
	
	
	
}

