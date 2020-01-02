package client;

import lombok.extern.log4j.Log4j;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

@Log4j
public class ResourceClient extends AbstractClient {
    private static final String ADDITIONAL_URL_PART = "unknown";
    private static final String RESOURCE_URL = BASE_URL + ADDITIONAL_URL_PART;

   public ResourceClient() {
        super(RESOURCE_URL);
    }

    @GET
    public Response getResourceById(int id) {
                 client
                .path(id)
                .accept(APPLICATION_JSON_TYPE)
                .type(APPLICATION_JSON_TYPE);
        return client.get();
    }

    @GET
    public Response getAllResources() {
                 client
                .accept(APPLICATION_JSON_TYPE)
                .type(APPLICATION_JSON_TYPE);
        return client.get();
    }
}
