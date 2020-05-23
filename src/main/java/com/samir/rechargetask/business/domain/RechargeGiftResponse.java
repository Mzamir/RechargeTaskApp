package com.samir.rechargetask.business.domain;

import com.samir.rechargetask.data.entity.Gift;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class RechargeGiftResponse {

    private String msisdn;
    private int rechargeValue;
    private int numberOfAssignedGifts;
    private String status;
    private List<Gift> gifts = new ArrayList<>();

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

    public List<Gift> getGifts() {
        return gifts;
    }

    public void setGifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    @Override
    public String toString() {
        return "Response [msisdn=" + msisdn +
                ", rechargeValue=" + rechargeValue +
                ", numberOfAssignedGifts=" + numberOfAssignedGifts +
                ", status=" + status +
                "]";
    }
}
