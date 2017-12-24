package edu.grabduck.service;

import edu.grabduck.model.StackOverflowWebsite;
import edu.grabduck.persistence.StackOverflowWebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    @Autowired
    public void setRepository(StackOverflowWebsiteRepository repository) {
        this.repository = repository;
    }

    private StackOverflowWebsiteRepository repository;

    public List<StackOverflowWebsite> getAll() {
        return repository.findAll();
    }
}
