package com.example.SpringSecurity.entities;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {

	@Id
	@NotEmpty
	@Column(unique = true)
	private String username;
	@NotEmpty
	private String name;
	@Size(min = 4)
	private String password;
	private boolean isStakeholderUser;
	@ManyToOne
	@JoinColumn(name = "stakeholderId")
	private StakeholderInfo stakeholderInfo;
	private String createdBy;
	@Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
	private LocalDateTime createdTime;
	private String updatedBy;
	@Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
	private LocalDateTime updatedTime;
	private boolean status;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLES", joinColumns={
			@JoinColumn(name = "USER_USERNAME", referencedColumnName = "username") }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_NAME", referencedColumnName = "name") })
	private List<Role> roles;

	public User() {
	}

	public User(String username, String name, String password, boolean isStakeholderUser, StakeholderInfo stakeholderInfo, String createdBy, LocalDateTime createdTime, String updatedBy, LocalDateTime updatedTime, boolean status) {
		this.username = username;
		this.name = name;
		this.password = password;
		this.isStakeholderUser = isStakeholderUser;
		this.stakeholderInfo = stakeholderInfo;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.updatedBy = updatedBy;
		this.updatedTime = updatedTime;
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStakeholderUser() {
		return isStakeholderUser;
	}

	public void setStakeholderUser(boolean stakeholderUser) {
		isStakeholderUser = stakeholderUser;
	}

	public StakeholderInfo getStakeholderInfo() {
		return stakeholderInfo;
	}

	public void setStakeholderInfo(StakeholderInfo stakeholderInfo) {
		this.stakeholderInfo = stakeholderInfo;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
