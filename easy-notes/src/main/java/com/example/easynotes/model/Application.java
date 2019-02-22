package com.example.easynotes.model;

import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "application")
public class Application implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Application_id")
	private Integer Id;
	@Column(name = "app_name", nullable = false)
	private String name;
	@Column(length = 2000)
	private String description;
	private String owner;

	public Application() {

	}

	public Application(Integer id, String name, String description, String owner) {
		super();
		Id = id;
		this.name = name;
		this.description = description;
		this.owner = owner;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
