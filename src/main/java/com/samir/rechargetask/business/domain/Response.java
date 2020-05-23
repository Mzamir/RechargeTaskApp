package com.samir.rechargetask.business.domain;

public class Response {

    private String msisdn;
    private int rechargeValue;

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

    @Override
    public String toString() {
    return "Response [msisdn=" + msisdn + ", rechargeValue=" + rechargeValue + "]";
}
}
