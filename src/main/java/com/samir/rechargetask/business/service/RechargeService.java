package com.samir.rechargetask.business.service;

import com.samir.rechargetask.business.domain.RechargeGiftResponse;
import com.samir.rechargetask.data.entity.Gift;
import com.samir.rechargetask.data.entity.Recharge;
import com.samir.rechargetask.data.repository.GiftRepository;
import com.samir.rechargetask.utils.Status;
import com.samir.rechargetask.data.repository.RechargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RechargeService {
    private final RechargeRepository rechargeRepository;
    private final GiftRepository giftRepository;

    @Autowired
    public RechargeService(RechargeRepository rechargeRepository, GiftRepository giftRepository) {
        this.rechargeRepository = rechargeRepository;
        this.giftRepository = giftRepository;
    }

    public RechargeGiftResponse getGiftsForMSISDN(String msisdn, int rechargeAmount) {
        RechargeGiftResponse rechargeGiftResponse = new RechargeGiftResponse();
        Recharge recharge = this.rechargeRepository.findByMsisdn(msisdn);
        Gift gift = new Gift(rechargeAmount * 10);
        if (recharge == null) {
            recharge = new Recharge();
            recharge.setMsisdn(msisdn);
            recharge.setRechargeValue(rechargeAmount);
            recharge.setNumberOfAssignedGifts(1);
            recharge.setStatus(Status.SUCCESS);

        } else {
            if (recharge.getNumberOfAssignedGifts() < 3) {
                recharge.setRechargeValue(rechargeAmount);
                recharge.setNumberOfAssignedGifts(recharge.getNumberOfAssignedGifts() + 1);
                recharge.setStatus(Status.SUCCESS);
            } else {
                recharge.setRechargeValue(rechargeAmount);
                recharge.setStatus(Status.MAX_GIFT_REACHED);
                gift.setGiftValue(0);
            }
        }
        gift.setRecharge(recharge);
        rechargeRepository.save(recharge);
        giftRepository.save(gift);

        Iterable<Gift> giftEntities = giftRepository.findAllByRecharge(recharge);
        List<Gift> gifts = new ArrayList<>();
        giftEntities.forEach(giftEntity -> {
            gifts.add(giftEntity);
        });
        rechargeGiftResponse.setMsisdn(msisdn);
        rechargeGiftResponse.setRechargeValue(rechargeAmount);
        rechargeGiftResponse.setNumberOfAssignedGifts(recharge.getNumberOfAssignedGifts());
        rechargeGiftResponse.setStatus(recharge.getStatus());
        rechargeGiftResponse.setGifts(gifts);
        return rechargeGiftResponse;
    }
}
