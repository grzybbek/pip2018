package pl.hycom.ip2018.searchengine.localsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.hycom.ip2018.searchengine.localsearch.exception.LocalSearchException;
import pl.hycom.ip2018.searchengine.localsearch.model.LocalSearchResponse;
import pl.hycom.ip2018.searchengine.localsearch.service.DefaultLocalSearch;
import pl.hycom.ip2018.searchengine.localsearch.service.LocalSearch;
import pl.hycom.ip2018.searchengine.providercontract.ProviderResponse;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Controller returns json objects
 */
@RestController
public class LocalSearchServiceController {

    @Autowired
    private LocalSearch defaultLocalSearch;

    /**
     * Endpoint from other services
     *
     * @param query we are searching for
     * @return object representation of response
     */
    @RequestMapping(value = "/res/{query}", method = GET)
    public ProviderResponse getResponseFromLocal(@PathVariable String query) throws LocalSearchException {
        return defaultLocalSearch.getResponseFromLocalByQuery(query);
    }
}
