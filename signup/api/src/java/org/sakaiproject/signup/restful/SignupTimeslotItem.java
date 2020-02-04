/**
 * Copyright (c) 2007-2014 The Apereo Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *             http://opensource.org/licenses/ecl2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
* Licensed to The Apereo Foundation under one or more contributor license
* agreements. See the NOTICE file distributed with this work for
* additional information regarding copyright ownership.
*
* The Apereo Foundation licenses this file to you under the Educational 
* Community License, Version 2.0 (the "License"); you may not use this file 
* except in compliance with the License. You may obtain a copy of the 
* License at:
*
* http://opensource.org/licenses/ecl2.txt
* 
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.sakaiproject.signup.restful;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * This class holds the information of sign-up time slot. It's a wrapper class
 * for RESTful case.
 * </p>
 */
public class SignupTimeslotItem {

	private Long id;

	private Date startTime;

	private Date endTime;

	private boolean locked;

	private boolean canceled;

	private int maxNoOfAttendees;

	private boolean displayAttendees;// TODO : this should be moved to

	// meeting class

	private List<SignupParticipant> attendees;

	private List<SignupParticipant> waitingList;

	private boolean signedUp;

	private boolean onWaitList;

	/**
	 * a constants maximum number for attendees
	 */
	public static final int UNLIMITED = Integer.MAX_VALUE;

	/**
	 * constructor
	 * 
	 */
	public SignupTimeslotItem() {
		attendees = new ArrayList<SignupParticipant>();
		waitingList = new ArrayList<SignupParticipant>();
	}

	/**
	 * get the sequence Id, which is generated by DB
	 * 
	 * @return the sequence Id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * this is a setter
	 * 
	 * @param id
	 *            the sequence Id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * get the starting time of the time slot
	 * 
	 * @return the starting time of the time slot
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * this is a setter
	 * 
	 * @param startTime
	 *            the starting time of the time slot
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * get the end time when the time slot ends
	 * 
	 * @return the end time
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * this is a setter
	 * 
	 * @param endTime
	 *            a end time
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * check if this time slot is cancelled
	 * 
	 * @return true if this time slot is cancelled
	 */
	public boolean isCanceled() {
		return canceled;
	}

	/**
	 * this is a setter
	 * 
	 * @param cancel
	 *            a boolean value
	 */
	public void setCanceled(boolean cancel) {
		this.canceled = cancel;
	}

	/**
	 * check if the time slot is locked
	 * 
	 * @return true if the time slot is locked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * this is a setter
	 * 
	 * @param locked
	 *            a boolean value
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	/**
	 * get a list of SignupParticipant objects, who have signed up in the time
	 * slot
	 * 
	 * @return a list of SignupParticipant objects
	 */
	public List<SignupParticipant> getAttendees() {
		return attendees;
	}

	/**
	 * this is a setter
	 * 
	 * @param attendees
	 *            a list of SignupParticipant objects
	 */
	public void setAttendees(List<SignupParticipant> attendees) {
		this.attendees = attendees;
	}

	/**
	 * get a list of SignupParticipant objects, who are on the waiting list in
	 * the time slot
	 * 
	 * @return a list of SignupParticipant objects
	 */
	public List<SignupParticipant> getWaitingList() {
		return waitingList;
	}

	/**
	 * this is a setter
	 * 
	 * @param waitingList
	 *            a list of SignupParticipant objects, who are on the waiting
	 *            list in the time slot
	 */
	public void setWaitingList(List<SignupParticipant> waitingList) {
		this.waitingList = waitingList;
	}

	/**
	 * check if the name of Attendee should be display to public
	 * 
	 * @return true if the name of Attendee should be display to public
	 */
	public boolean isDisplayAttendees() {
		return displayAttendees;
	}

	/**
	 * this is a setter
	 * 
	 * @param showAttendees
	 *            a boolean value
	 */
	public void setDisplayAttendees(boolean showAttendees) {
		this.displayAttendees = showAttendees;
	}

	/**
	 * check if current time slot is available for adding more people
	 * 
	 * @return true if current time slot is available for adding more people
	 */
	public boolean isAvailable() {
		if (attendees == null)
			return true;

		return (attendees.size() < maxNoOfAttendees);
	}

	/**
	 * check to see if current user is signed up
	 * 
	 * @return a boolean value
	 */
	public boolean isSignedUp() {
		return signedUp;
	}

	public void setSignedUp(boolean signedUp) {
		this.signedUp = signedUp;
	}

	/**
	 * Check to see if current user is on the waiting list
	 * 
	 * @return
	 */
	public boolean isOnWaitList() {
		return onWaitList;
	}

	public void setOnWaitList(boolean onWaitList) {
		this.onWaitList = onWaitList;
	}

	/**
	 * get the maximum number of attendees, which is allowed in the time slot
	 * 
	 * @return the maximum number of attendees
	 */
	public int getMaxNoOfAttendees() {
		return maxNoOfAttendees;
	}

	/**
	 * this is a setter
	 * 
	 * @param noOfAttendees
	 *            the maximum allowed number of attendees
	 */
	public void setMaxNoOfAttendees(int noOfAttendees) {
		this.maxNoOfAttendees = noOfAttendees;
	}

	/**
	 * check if the time slot allows unlimited attendee to join
	 * 
	 * @return true if the time slot allows unlimited attendee to join
	 */
	public boolean isUnlimitedAttendee() {
		return (maxNoOfAttendees == UNLIMITED);
	}

}
