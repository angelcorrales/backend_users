package com.bbva.play.user.dto;

import java.io.Serializable;

public class MissionDto implements Serializable {
    
    private static final long serialVersionUID = 934200381965823305L;

    private String id;

    private String description;
    
    private String image;

    private Amount amount;

    private String status;

    public MissionDto() {
        super();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
    }

	@Override
	public String toString() {
		return "MissionDto [id=" + id + "]";
	}
}