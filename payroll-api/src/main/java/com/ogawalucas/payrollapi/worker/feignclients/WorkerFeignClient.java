package com.ogawalucas.payrollapi.worker.feignclients;

import com.ogawalucas.payrollapi.worker.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "worker", url = "localhost:8001", path = "/workers")
public interface WorkerFeignClient {

    @GetMapping("{id}")
    Worker findById(@PathVariable Long id);
}
