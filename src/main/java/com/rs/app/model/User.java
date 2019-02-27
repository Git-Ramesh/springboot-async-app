/*
 *  com.rs.model.User.java  Feb 27, 2019
 *
 *  © Radiant Sage.
 *  Manjeera Trinity Corporate, Plot No. 912,K P H B Phase 3, Kukatpally, Hyderabad, Telangana 500072,INDIA.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of
 *  Radiant Sage . ("Confidential Information").  You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Radiant Sage.
 */
package com.rs.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Ramesh
 * @version 1.0
 * @since 2019-02-27 12:32:12.465
 */
@Entity
@Table(name = "USER_TAB")
public class User implements Serializable {
	private static final long serialVersionUID = -7258241760050524890L;
	@Id
	@SequenceGenerator(name = "USER_ID_SEQ_GEN", sequenceName = "USER_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "USER_ID_SEQ_GEN", strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;

	public User() {
		// ...
	}

	public User(long id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}
