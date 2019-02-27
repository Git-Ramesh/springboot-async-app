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
package com.rs.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Ramesh
 * @version 1.0
 * @since 2019-02-27 12:32:12.465
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
	private static final long serialVersionUID = -7928491201487799632L;
	private long id;
	private String name;
	private String address;
}
