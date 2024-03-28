package com.HRMS.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_demands")
public class DemandMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long demandId;

	@ManyToOne
	@JoinColumn(name = "projectId")
	private ProjectMaster Project;

	private Date demandDate;

	@ManyToOne
	@JoinColumn(name="designationId")
	private DesignationMaster Position;
	
	private String requiredSkills;
	private String Priority;
	private String numberOfPositions;
	
	
	@Lob
	@Column(columnDefinition = "LONGTEXT")
	private String Description;

	
	private String Status;
	private String demandType;
	private String location;
	private String salary;
	
	
	
	

	

}
