package com.example.SpringSecurity.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Role {

	@Id
	private String name;
	private String description;
	@ManyToMany(mappedBy = "roles")
	private List<User> users;

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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Role(String name, String description, List<User> users) {
		this.name = name;
		this.description = description;
		this.users = users;
	}

	public Role() {
	}

	public Role(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
