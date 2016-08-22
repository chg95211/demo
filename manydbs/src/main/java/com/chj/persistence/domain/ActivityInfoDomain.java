/*
 * Copyright (c) 2015, Shanghai OnStar. All rights reserved.
 */
package com.chj.persistence.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 活动信息 DTO
 */
@Entity
@Table(name = "T_ACTIVITY_INFO")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties
public class ActivityInfoDomain extends BaseDomain<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, unique = true)
	private Integer id;

	@Column(name = "ACTIVITY_TYPE", nullable = false, length = 20)
	private String activityType;

	@Column(name = "ACTIVITY_NUM", nullable = false, unique = true, length = 20)
	private String activityNum;

	@Column(name = "ACTIVITY_NAME", length = 50)
	private String activityName;

	@Column(name = "ACTIVITY_DESCRIPTION", length = 2000)
	private String activityDescription;

	@Column(name = "ACTIVITY_DATA", length = 2000)
	private String activityData;

	@Column(name = "ACTIVITY_EXPIRE_DATE")
	@Temporal(TemporalType.DATE)
	private Date activityExpireDate;

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getActivityNum() {
		return activityNum;
	}

	public void setActivityNum(String activityNum) {
		this.activityNum = activityNum;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public String getActivityData() {
		return activityData;
	}

	public void setActivityData(String activityData) {
		this.activityData = activityData;
	}

	public Date getActivityExpireDate() {
		return activityExpireDate;
	}

	public void setActivityExpireDate(Date activityExpireDate) {
		this.activityExpireDate = activityExpireDate;
	}
	
//	@SuppressWarnings("unchecked")
//	public List<DzpDataDTO> getData(){
//		if(StringUtils.isNotEmpty(this.activityData)){
//			try {
//				return (List<DzpDataDTO>) JsonUtils.jsonStringToBeanList(this.activityData, DzpDataDTO.class);
//			} catch (BaseException e) {
//				e.printStackTrace();
//				return null;
//			}
//		}
//		return null;
//	}

}
