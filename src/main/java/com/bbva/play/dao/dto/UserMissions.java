package com.bbva.play.dao.dto;

import java.io.Serializable;

public class UserMissions implements Serializable {

    private static final long serialVersionUID = -6562406563143063223L;
    
    private String missionId;

    private String userId;

	public String getMissionId() {
		return missionId;
	}

	public void setMissionId(String missionId) {
		this.missionId = missionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}