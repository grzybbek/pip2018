package pl.hycom.ip2018.searchengine.aggregate.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import pl.hycom.ip2018.searchengine.aggregate.service.AggregateSearch;
import pl.hycom.ip2018.searchengine.providercontract.ProviderResponse;

@RestController
@Api
public class AggregateController {

    @Autowired
    private AggregateSearch aggregateSearch;

    @HystrixCommand(fallbackMethod = "getMessageFallBack", commandKey = "Aggregate-Search-Service", groupKey = "GetMessage")
    @RequestMapping(value = "/res/{query}", method = GET)
    public ProviderResponse getMessage(@PathVariable String query) {
        return aggregateSearch.getResponse(query);
    }

    public ProviderResponse getMessageFallBack(String query) {
        return new ProviderResponse(new ArrayList<>());
    }
}
