package com.samir.rechargetask.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RECHARGES")
public class Recharge {

    @Id
    @Column(name = "MSISDN")
    private String msisdn;

    @Column(name = "RECHARGE_VALUE")
    private int rechargeValue;

    @Column(name = "COUNTER")
    private int numberOfAssignedGifts;

    @Column(name = "STATUS")
    private String status;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public int getRechargeValue() {
        return rechargeValue;
    }

    public void setRechargeValue(int rechargeValue) {
        this.rechargeValue = rechargeValue;
    }

    public int getNumberOfAssignedGifts() {
        return numberOfAssignedGifts;
    }

    public void setNumberOfAssignedGifts(int numberOfAssignedGifts) {
        this.numberOfAssignedGifts = numberOfAssignedGifts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
