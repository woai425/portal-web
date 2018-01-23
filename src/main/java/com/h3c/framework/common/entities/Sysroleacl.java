package com.h3c.framework.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sysroleacl entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sysroleacl")
public class Sysroleacl implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String resourceid;
	private String roleid;
	private String hashcode;
	private String functionid;

	// Constructors

	/** default constructor */
	public Sysroleacl() {
	}

	/** minimal constructor */
	public Sysroleacl(String resourceid, String roleid, String functionid) {
		this.resourceid = resourceid;
		this.roleid = roleid;
		this.functionid = functionid;
	}

	/** full constructor */
	public Sysroleacl(String resourceid, String roleid, String hashcode,
			String functionid) {
		this.resourceid = resourceid;
		this.roleid = roleid;
		this.hashcode = hashcode;
		this.functionid = functionid;
	}

	// Property accessors
	@Id
	@Column(name = "RESOURCEID", unique = true, nullable = false, length = 40)
	public String getResourceid() {
		return this.resourceid;
	}

	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}

	@Column(name = "ROLEID", nullable = false, length = 40)
	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	@Column(name = "HASHCODE", length = 64)
	public String getHashcode() {
		return this.hashcode;
	}

	public void setHashcode(String hashcode) {
		this.hashcode = hashcode;
	}

	@Column(name = "FUNCTIONID", nullable = false, length = 32)
	public String getFunctionid() {
		return this.functionid;
	}

	public void setFunctionid(String functionid) {
		this.functionid = functionid;
	}

}