package com.ogawalucas.payrollapi.payment.services;

import com.ogawalucas.payrollapi.payment.entities.Payment;
import com.ogawalucas.payrollapi.worker.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {
        var worker = workerFeignClient.findById(workerId);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
