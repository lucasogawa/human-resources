package com.ogawalucas.workerapi.worker.resources;

import com.ogawalucas.workerapi.commons.expections.NotFoundException;
import com.ogawalucas.workerapi.worker.entities.Worker;
import com.ogawalucas.workerapi.worker.repositories.WorkerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("workers")
public class WorkerResource {

    @Autowired
    private Environment env;
    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public List<Worker> findAll() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Worker findById(@PathVariable Long id) {
        log.info("Port = " + env.getProperty("local.server.port"));

        return repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Worker"));
    }

    @GetMapping("configs")
    public void printConfigs() {
        log.info("Config: {}", testConfig);
    }
}
