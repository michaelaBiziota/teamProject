/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.paypal;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author bizmi
 */
@Service
public class PayPalClient {
  String clientId = "ASusynDkqoPMuUr2mGt_cxbVqiI0_bZ8N-76m03dnfVK9I9aD5tltVZg4qEBeu0RX4iLx9YZj3xfjOo6";
String clientSecret = "EACoVzgxBHbVORbNVpHJghIlATeDTaZ6PHZT4MzSFQ-c97ASGAQR2kXKvLQB1Xjq7vZlM77adM1WO8U-";
public Map<String, Object> createPayment(String sum){
    Map<String, Object> response = new HashMap<String, Object>();
    Amount amount = new Amount();
    amount.setCurrency("USD");
    amount.setTotal(sum);
    Transaction transaction = new Transaction();
    transaction.setAmount(amount);
    List<Transaction> transactions = new ArrayList<Transaction>();
    transactions.add(transaction);

    Payer payer = new Payer();
    payer.setPaymentMethod("paypal");

    Payment payment = new Payment();
    payment.setIntent("sale");
    payment.setPayer(payer);
    payment.setTransactions(transactions);

    RedirectUrls redirectUrls = new RedirectUrls();
    redirectUrls.setCancelUrl("http://localhost:8080/cancel");
    redirectUrls.setReturnUrl("http://localhost:8080/movieNights/index.jsp");
    payment.setRedirectUrls(redirectUrls);
    Payment createdPayment;
    try {
        String redirectUrl = "";
        APIContext context = new APIContext(clientId, clientSecret, "sandbox");
        createdPayment = payment.create(context);
        if(createdPayment!=null){
            List<Links> links = createdPayment.getLinks();
            for (Links link:links) {
                if(link.getRel().equals("approval_url")){
                    redirectUrl = link.getHref();
                    break;
                }
            }
            response.put("status", "success");
            response.put("redirect_url", redirectUrl);
        }
    } catch (PayPalRESTException e) {
        System.out.println("Error happened during payment creation!");
    }
    return response;
} 


public Map<String, Object> completePayment(HttpServletRequest req){
    Map<String, Object> response = new HashMap();
    Payment payment = new Payment();
    payment.setId(req.getParameter("paymentId"));


    PaymentExecution paymentExecution = new PaymentExecution();
    paymentExecution.setPayerId(req.getParameter("PayerID"));
    try {
        APIContext context = new APIContext(clientId, clientSecret, "sandbox");
        Payment createdPayment = payment.execute(context, paymentExecution);
        if(createdPayment!=null){
            response.put("status", "success");
            response.put("payment", createdPayment);
        }
    } catch (PayPalRESTException e) {
        System.err.println(e.getDetails());
    }
    return response;
}
}
