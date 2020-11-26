package com.bbva.play.user.dto;

import java.io.Serializable;

public class Amount implements Serializable {

    private static final long serialVersionUID = -8791974978168082678L;

    private Double amount;
    
    private String currency;

    public Amount(Double amount, String currency) {
        super();
        this.amount = amount;
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}