package com.samir.rechargetask.data.repository;

import com.samir.rechargetask.data.entity.Gift;
import com.samir.rechargetask.data.entity.Recharge;
import org.springframework.data.repository.CrudRepository;

public interface GiftRepository extends CrudRepository<Gift, Long> {
    Iterable<Gift> findAllByRecharge(Recharge recharge);

}
