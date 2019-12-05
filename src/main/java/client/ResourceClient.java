package client;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

@Log4j
public class ResourceClient extends AbstractClient {
    private static final String ADDITIONAL_URL_PART = "unknown";
    private static final String RESOURCE_URL = BASE_URL + ADDITIONAL_URL_PART;

    @GET
    public Response getResourceById(int id) {
        log.info("Visit URL: " + RESOURCE_URL);
        WebClient client = WebClient
                .create(RESOURCE_URL, providers)
                .path(id)
                .accept(APPLICATION_JSON_TYPE)
                .type(APPLICATION_JSON_TYPE);
        log.info("Search resource with id:  " + id);
        return client.get();
    }

    @GET
    public Response getAllResources() {
        WebClient client = WebClient
                .create(RESOURCE_URL, providers)
                .accept(APPLICATION_JSON_TYPE)
                .type(APPLICATION_JSON_TYPE);
        log.info("Get all resources.....");
        return client.get();
    }
}
