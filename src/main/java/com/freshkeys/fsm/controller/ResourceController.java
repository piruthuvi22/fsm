package com.freshkeys.fsm.controller;

import com.freshkeys.fsm.entity.Resource;
import com.freshkeys.fsm.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResourceController {
    @Autowired
    private ResourceService service;


    @PostMapping("/add-resource")
    public Resource addResource(@RequestBody Resource resource) {
        return service.saveResource(resource);
    }

    @GetMapping("/get-resources")
    public List<Resource> getAllResource() {
        return service.getResource();
    }

    @GetMapping("/get-resource-by-id/{id}")
    public Resource getResourceById(@PathVariable int id) {
        return service.getResourceById(id);
    }

    @GetMapping("/get-resource-by-name/{name}")
    public Resource getResourceByName(@PathVariable String name) {
        return service.getResourceByName(name);
    }

    @PutMapping("/update-resource")
    public Resource updateResource(@RequestBody Resource resource) {
        return service.updateResource(resource);
    }

    @DeleteMapping("/delete-resource/{id}")
    public String deleteResource(@PathVariable int id) {
        return service.deleteResource(id);
    }

}
