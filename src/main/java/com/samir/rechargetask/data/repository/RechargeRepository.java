package com.samir.rechargetask.data.repository;

import com.samir.rechargetask.data.entity.Recharge;
import org.springframework.data.repository.CrudRepository;

public interface RechargeRepository extends CrudRepository<Recharge, String> {
    Recharge findByMsisdn(String msisdn);
}
