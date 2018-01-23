package com.h3c.framework.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sysparam entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sysparam")
public class Sysparam implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private String paramcode;
	private String paramname;
	private String paramvalue;
	private String paramexplain;
	private String maintstate;

	// Constructors

	/** default constructor */
	public Sysparam() {
	}

	/** minimal constructor */
	public Sysparam(String paramcode, String paramname, String paramvalue,
			String maintstate) {
		this.paramcode = paramcode;
		this.paramname = paramname;
		this.paramvalue = paramvalue;
		this.maintstate = maintstate;
	}

	/** full constructor */
	public Sysparam(String paramcode, String paramname, String paramvalue,
			String paramexplain, String maintstate) {
		this.paramcode = paramcode;
		this.paramname = paramname;
		this.paramvalue = paramvalue;
		this.paramexplain = paramexplain;
		this.maintstate = maintstate;
	}

	// Property accessors
	@Id
	@Column(name = "PARAMCODE", unique = true, nullable = false, length = 50)
	public String getParamcode() {
		return this.paramcode;
	}

	public void setParamcode(String paramcode) {
		this.paramcode = paramcode;
	}

	@Column(name = "PARAMNAME", nullable = false, length = 50)
	public String getParamname() {
		return this.paramname;
	}

	public void setParamname(String paramname) {
		this.paramname = paramname;
	}

	@Column(name = "PARAMVALUE", nullable = false, length = 65535)
	public String getParamvalue() {
		return this.paramvalue;
	}

	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}

	@Column(name = "PARAMEXPLAIN", length = 100)
	public String getParamexplain() {
		return this.paramexplain;
	}

	public void setParamexplain(String paramexplain) {
		this.paramexplain = paramexplain;
	}

	@Column(name = "MAINTSTATE", nullable = false, length = 1)
	public String getMaintstate() {
		return this.maintstate;
	}

	public void setMaintstate(String maintstate) {
		this.maintstate = maintstate;
	}

}