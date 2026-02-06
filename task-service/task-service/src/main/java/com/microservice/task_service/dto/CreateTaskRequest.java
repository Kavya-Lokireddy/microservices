package com.microservice.task_service.dto;


public class CreateTaskRequest {

    private String title;
    private String description;
    private Long assigneeId;
    
    public CreateTaskRequest() {
    	
    }
    
	public CreateTaskRequest(String title, String description, Long assigneeId) {
		super();
		this.title = title;
		this.description = description;
		this.assigneeId = assigneeId;
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
	public Long getAssigneeId() {
		return assigneeId;
	}
	public void setAssigneeId(Long assigneeId) {
		this.assigneeId = assigneeId;
	}

    // getters & setters
    
}