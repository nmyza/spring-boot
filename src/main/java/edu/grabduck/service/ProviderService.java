package edu.grabduck.service;

import edu.grabduck.model.StackOverflowWebsite;
import edu.grabduck.persistence.StackOverflowWebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {
    /*private static List<StackOverflowWebsite> sites = Arrays.asList(
            new StackOverflowWebsite("id1", "https://cdn3.iconfinder.com/data/icons/diagram_v2/PNG/32x32/diagram_v2-12.png", "http://google.com", "Title 1", "Description 1"),
            new StackOverflowWebsite("id2", "https://cdn3.iconfinder.com/data/icons/diagram_v2/PNG/32x32/diagram_v2-17.png", "http://google.com", "Title 2", "Description 2"),
            new StackOverflowWebsite("id3", "https://cdn3.iconfinder.com/data/icons/diagram_v2/PNG/32x32/diagram_v2-14.png", "http://google.com", "Title 3", "Description 3"),
            new StackOverflowWebsite("id4", "https://cdn3.iconfinder.com/data/icons/diagram_v2/PNG/32x32/diagram_v2-21.png", "http://google.com", "Title 4", "Description 4"),
            new StackOverflowWebsite("id5", "https://cdn3.iconfinder.com/data/icons/diagram_v2/PNG/32x32/diagram_v2-10.png", "http://google.com", "Title 5", "Description 5")
    );*/

    @Autowired
    public void setRepository(StackOverflowWebsiteRepository repository) {
        this.repository = repository;
    }


    private StackOverflowWebsiteRepository repository;

    // @PostConstruct
    // private void init() {
    //    repository.save(sites);
    // }

    public List<StackOverflowWebsite> getAll() {
        return repository.findAll();
    }
}
