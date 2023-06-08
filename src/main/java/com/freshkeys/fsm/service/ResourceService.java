package com.freshkeys.fsm.service;

import com.freshkeys.fsm.entity.Resource;
import com.freshkeys.fsm.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {
    @Autowired
    private ResourceRepository repository;

    public Resource saveResource(Resource resource){
        return repository.save(resource);
    }

    public List<Resource> saveResource(List<Resource> resource){
        return repository.saveAll(resource);
    }

    public List<Resource> getResource(){
        return repository.findAll();
    }

    public Resource getResourceById(int id){
        return repository.findById(id).orElse(null);
    }

    public Resource getResourceByName(String name){
        return repository.findByName(name);
    }

    public String deleteResource(int id){
        repository.deleteById(id);
        return "Resource removed " + id;
    }

    public Resource updateResource(Resource resource){

        Resource existingResource = repository.findById(resource.getId()).orElse(null);
        existingResource.setName(resource.getName());
        existingResource.setDescription(resource.getDescription());
        existingResource.setQuantity(resource.getQuantity());

        return repository.save(existingResource);
    }
}

