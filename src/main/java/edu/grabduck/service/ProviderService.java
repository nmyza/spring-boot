package edu.grabduck.service;

import com.google.common.collect.ImmutableList;
import edu.grabduck.model.SiteDto;
import edu.grabduck.model.StackOverflowWebsite;
import edu.grabduck.persistence.StackOverflowWebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

@Service
public class ProviderService {
    @Autowired
    public void setRepository(StackOverflowWebsiteRepository repository) {
        this.repository = repository;
    }

    private StackOverflowWebsiteRepository repository;

    @Autowired
    public void setStackExchangeClient(StackExchangeClient stackExchangeClient) {
        this.stackExchangeClient = stackExchangeClient;
    }

    private StackExchangeClient stackExchangeClient;

    public List<StackOverflowWebsite> findAll() {
        return stackExchangeClient.getSites().stream()
                .map(this::toStackOverflowWebsite)
                .filter(this::ignoreMeta)
                .collect(collectingAndThen(Collectors.toList(), ImmutableList::copyOf));
    }

    private boolean ignoreMeta(StackOverflowWebsite stackOverflowWebsite) {
        return !stackOverflowWebsite.getId().contains("meta");
    }

    private StackOverflowWebsite toStackOverflowWebsite(@NotNull SiteDto site) {
        return new StackOverflowWebsite(
                site.getSite_url().substring("https://".length(), site.getSite_url().length() - ".com".length()),
                site.getFavicon_url(),
                site.getSite_url(),
                site.getName(),
                site.getAudience());
    }

/*  public List<StackOverflowWebsite> findAll() {
        return repository.findAll();
    }
*/
    private static List<StackOverflowWebsite> sites = Arrays.asList(
            new StackOverflowWebsite("id1", "https://cdn3.iconfinder.com/data/icons/diagram_v2/PNG/32x32/diagram_v2-12.png", "http://google.com", "Title 1", "Description 1"),
            new StackOverflowWebsite("id2", "https://cdn3.iconfinder.com/data/icons/diagram_v2/PNG/32x32/diagram_v2-17.png", "http://google.com", "Title 2", "Description 2"),
            new StackOverflowWebsite("id3", "https://cdn3.iconfinder.com/data/icons/diagram_v2/PNG/32x32/diagram_v2-14.png", "http://google.com", "Title 3", "Description 3"),
            new StackOverflowWebsite("id4", "https://cdn3.iconfinder.com/data/icons/diagram_v2/PNG/32x32/diagram_v2-21.png", "http://google.com", "Title 4", "Description 4"),
            new StackOverflowWebsite("id5", "https://cdn3.iconfinder.com/data/icons/diagram_v2/PNG/32x32/diagram_v2-10.png", "http://google.com", "Title 5", "Description 5")
    );

    @PostConstruct
    private void init() {
       repository.save(sites);
    }
}
