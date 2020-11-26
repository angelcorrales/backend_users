package org.acme.backend.dao.dto;

import java.io.Serializable;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;

@Entity
public class UserMissions extends PanacheEntity implements Serializable {

    private static final long serialVersionUID = -6562406563143063223L;
    
    private Long id;

    private Long relatedUser;

    private String description;
    
    private String image;

    private Double amount;

    private String state;

    public UserMissions() {
        super();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
    }

	public Long getRelatedUser() {
		return relatedUser;
	}

	public void setRelatedUser(Long relatedUser) {
		this.relatedUser = relatedUser;
	}
    
}