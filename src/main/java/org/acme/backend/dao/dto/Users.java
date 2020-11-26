package org.acme.backend.dao.dto;

import java.io.Serializable;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.List;

@Entity
public class Users extends PanacheEntity implements Serializable {

    private static final long serialVersionUID = -6562406563103063223L;
    
    private Long id;

    @NotNull
    private String name;

    private String lastname;

    private Double totalMoney;

    private String avatar;

    public Users() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(final Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(final String avatar) {
        this.avatar = avatar;
    }


    
}