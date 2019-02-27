/*
 *  com.rs.app.repo.UserRepo.java  Feb 27, 2019
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
package com.rs.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.app.model.User;

/**
 * @author Ramesh
 * @version 1.0
 * @since 2019-02-27 17:08:08.875
 */
public interface UserRepo extends JpaRepository<User, Long> {

}
