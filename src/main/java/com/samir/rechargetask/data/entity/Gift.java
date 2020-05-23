package com.samir.rechargetask.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "GIFTS")
public class Gift {

    @Id
    @Column(name = "GIFT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "GIFT_VALUE")
    private int giftValue;
    @Column(name = "GIFT_PRICE")
    private final int giftPrice = 0;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RECHARGE_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Recharge recharge;

    public Gift() {
    }

    public Gift(int giftValue) {
        this.giftValue = giftValue;
    }

    public int getGiftValue() {
        return giftValue;
    }

    public void setGiftValue(int giftValue) {
        this.giftValue = giftValue;
    }

    public int getGiftPrice() {
        return giftPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recharge getRecharge() {
        return recharge;
    }

    public void setRecharge(Recharge recharge) {
        this.recharge = recharge;
    }
}
