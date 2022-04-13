package com.ogawalucas.payrollapi.payment.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ogawalucas.payrollapi.payment.entities.Payment;
import com.ogawalucas.payrollapi.payment.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @GetMapping("{workerId}/{days}")
    @HystrixCommand(fallbackMethod = "geyPaymentAlternative")
    public Payment getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        return service.getPayment(workerId, days);
    }

    public Payment geyPaymentAlternative(Long workerId, Integer days) {
        return new Payment("Brann", 400.0, days);
    }
}
