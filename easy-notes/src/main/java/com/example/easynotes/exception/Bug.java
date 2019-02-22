package com.example.easynotes.exception;

import javax.persistence.*;

import com.example.easynotes.model.Application;
import com.example.easynotes.model.Release;
import com.example.easynotes.model.Ticket;

@Entity
public class Bug extends Ticket {
	private Integer severity;
	private String rootCause;

	public Bug() {
	}

	public Bug(Integer severity, String rootCause) {
		this.severity = severity;
		this.rootCause = rootCause;
	}

	public Bug(Integer id, String title, String description, Application application, Release release, String status) {
		super(id, title, description, application, release, status);
		// TODO Auto-generated constructor stub
	}

	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}
}
