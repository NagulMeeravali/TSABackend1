package com.talentstream.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class ApplicantStatusHistory {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name = "applyjobid")
	private ApplyJob applyJob;
	
	private String status;
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime changeDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ApplyJob getApplyJob() {
		return applyJob;
	}
	public void setApplyJob(ApplyJob applyJob) {
		this.applyJob = applyJob;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(LocalDateTime changeDate) {
		this.changeDate = changeDate;
	}
	
}