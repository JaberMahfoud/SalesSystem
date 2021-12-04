/**
 * 
 */
package com.salesSystem.mvc.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author Jaber
 *
 */
@Entity
public class Log {
	

	@Id
	@SequenceGenerator(
			name="log_sequence",
			sequenceName="log_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "log_sequence"
			)
	private Integer id;
	private String className;
	private String method;
	private String arguments;
	private String response; 
	private Long executionTime; 
	@Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime creationDate;
	public Log(String className, String method, String arguments, String response, Long executionTime,
			LocalDateTime creationDate) {
		this.className = className;
		this.method = method;
		this.arguments = arguments;
		this.response = response;
		this.executionTime = executionTime;
		this.creationDate = creationDate;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getArguments() {
		return arguments;
	}
	public void setArguments(String arguments) {
		this.arguments = arguments;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Long getExecutionTime() {
		return executionTime;
	}
	public void setExecutionTime(Long executionTime) {
		this.executionTime = executionTime;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getCreationDate() {
	    
		return creationDate;
	}
}
