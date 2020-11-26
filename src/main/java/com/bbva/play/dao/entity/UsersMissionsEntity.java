package com.bbva.play.dao.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Sort;

@Entity
@Table(name = "usersmissions")
public class UsersMissionsEntity extends PanacheEntity {

    @Column(name = "missionid")
    private Long missionId;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "status")
    private String status;

	public Long getMissionId() {
		return missionId;
	}

	public void setMissionId(Long missionId) {
		this.missionId = missionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
    }
    
    public static List<UsersMissionsEntity> findByUserId(Long userId){
        return list("userid", Sort.by("missionid"),  userId);
    }

	@Override
	public String toString() {
		return "UsersMissionsEntity [missionId=" + missionId + "]";
	}
}