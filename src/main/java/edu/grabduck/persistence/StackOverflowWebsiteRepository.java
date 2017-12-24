package edu.grabduck.persistence;

import edu.grabduck.model.StackOverflowWebsite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StackOverflowWebsiteRepository extends MongoRepository<StackOverflowWebsite,  String> {
    List<StackOverflowWebsite> findByWebsite(String website);
}
