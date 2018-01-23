package com.h3c.framework.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sysusergroupref entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sysusergroupref")
public class Sysusergroupref implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String usergroupid;
	private String userid;
	private String groupid;
	private String isleader;

	// Constructors

	/** default constructor */
	public Sysusergroupref() {
	}

	/** minimal constructor */
	public Sysusergroupref(String usergroupid) {
		this.usergroupid = usergroupid;
	}

	/** full constructor */
	public Sysusergroupref(String usergroupid, String userid, String groupid,
			String isleader) {
		this.usergroupid = usergroupid;
		this.userid = userid;
		this.groupid = groupid;
		this.isleader = isleader;
	}

	// Property accessors
	@Id
	@Column(name = "USERGROUPID", unique = true, nullable = false, length = 32)
	public String getUsergroupid() {
		return this.usergroupid;
	}

	public void setUsergroupid(String usergroupid) {
		this.usergroupid = usergroupid;
	}

	@Column(name = "USERID", length = 32)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "GROUPID", length = 32)
	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	@Column(name = "ISLEADER", length = 1)
	public String getIsleader() {
		return this.isleader;
	}

	public void setIsleader(String isleader) {
		this.isleader = isleader;
	}

}