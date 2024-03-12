package com.HRMS.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_projects")
public class ProjectMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;
	
	private String projectName;
	private String projectDescription;
	private Date startDate;
	private Date endDate;
	private String Status;
	private String Priority;
	private String location;
	private String ProjectType;
	private long budget;
	
	@ManyToOne
	@JoinColumn(name="clientId")
	private ClientMaster Client;

	@ManyToOne
	@JoinColumn(name = "managerId")
	private EmployeeMaster projectManager;

	
	
	
}
