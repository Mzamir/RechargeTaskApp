package com.samir.rechargetask.web;

import com.samir.rechargetask.business.domain.RechargeGiftResponse;
import com.samir.rechargetask.business.domain.Response;
import com.samir.rechargetask.business.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class RechargeWebController {
    private final RechargeService rechargeService;

    @Autowired
    public RechargeWebController(RechargeService rechargeService) {
        this.rechargeService = rechargeService;
    }


//    @RequestMapping(value = "gifts/{msisdn}/{rechargeValue}", method = RequestMethod.GET)
//    public String giftResponse(@PathVariable String msisdn, @PathVariable String rechargeValue, Model model) {
//        System.out.println("giftResponse " + msisdn + " " + rechargeValue);
//        RechargeGiftResponse response = this.rechargeService.getGiftsForMSISDN(String.valueOf(msisdn)
//                , Integer.parseInt(rechargeValue));
//        model.addAttribute("response", response);
//        return "gifts";
//    }

    @GetMapping("/recharge")
    public String rechargeForm(Model model) {
        System.out.println("rechargeForm");
        model.addAttribute("response", new RechargeGiftResponse());
        return "recharge";
    }

    @PostMapping("/recharge")
    public String submitRechargeForm(@ModelAttribute("response") Response response, Model model) {
        System.out.println("submitRechargeForm " + response);
        RechargeGiftResponse c_response = rechargeService.getGiftsForMSISDN(String.valueOf(response.getMsisdn()), response.getRechargeValue());
        model.addAttribute("rechargeGiftResponse", c_response);
        model.addAttribute("gifts", c_response.getGifts());
        System.out.println("submitRechargeForm " + c_response);
        return "gifts";
    }

}
