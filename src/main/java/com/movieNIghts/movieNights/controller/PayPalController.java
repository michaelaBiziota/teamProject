/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.controller;

import com.movieNIghts.movieNights.paypal.PayPalClient;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bizmi
 */
@Controller
@RequestMapping(value = "/paypal")
public class PayPalController {

    private final PayPalClient payPalClient;
    @Autowired
    PayPalController(PayPalClient payPalClient){
        this.payPalClient = payPalClient;
    }
//@ResponseBody
    @PostMapping(value = "/make/payment")
    public String makePayment(@RequestParam("sum") String sum){
        return "redirect:" + payPalClient.createPayment(sum);
    }
    
    @GetMapping(value = "/complete/payment")
public String completePayment(HttpServletRequest request){
     payPalClient.completePayment(request);
     return "payPalSuccess";
}

//    @GetMapping(value = "/semicomplete")
//public String semicompletePayment(ModelMap mm,@RequestParam("paymentId") String p, @RequestParam("PayerID") String pa){
//    mm.addAttribute("payment",p);
//    mm.addAttribute("payer",pa);
//    return "payPalSuccess";
}



