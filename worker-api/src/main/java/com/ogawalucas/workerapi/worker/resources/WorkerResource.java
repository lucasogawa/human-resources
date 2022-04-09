package com.ogawalucas.workerapi.worker.resources;

import com.ogawalucas.workerapi.commons.expections.NotFoundException;
import com.ogawalucas.workerapi.worker.entities.Worker;
import com.ogawalucas.workerapi.worker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public List<Worker> findAll() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Worker findById(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Worker"));
    }
}
