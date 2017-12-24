package edu.grabduck.web;

import edu.grabduck.model.StackOverflowWebsite;
import edu.grabduck.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @Controller - means that response is template name *.ftl
@RestController
@RequestMapping("/api")
public class StackOverflowController {

    private ProviderService providerService;

    @Autowired
    public void setProviderService(ProviderService providerService) {
        this.providerService = providerService;
    }

    @RequestMapping("/providers")
    // @ResponseBody - means that response is JSON
    public List<StackOverflowWebsite> getProviders() {
        return providerService.getAll();
    }
}
