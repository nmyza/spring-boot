package edu.grabduck.service;

import edu.grabduck.model.SiteDto;
import edu.grabduck.model.SitesDto;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class StackExchangeClient {
    private HttpClient httpClient = HttpClientBuilder.create().build();
    private ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private RestTemplate rest = new RestTemplate(requestFactory);
    //private RestTemplate rest = new RestTemplate();

    List<SiteDto> getSites() {
        String url = "https://api.stackexchange.com/2.2/sites?page=1&pagesize=999&filter=!8IeYYZbP7kF8WkCg(i*zC";
        SitesDto response = rest.getForObject(url, SitesDto.class);
        return response.getItems();
    }
}
