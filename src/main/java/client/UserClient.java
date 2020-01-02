package client;

import lombok.extern.log4j.Log4j;
import model.entity.JobUser;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

@Log4j
public class UserClient extends AbstractClient {
    private static final String ADDITIONAL_URL_PART = "users";
    private static String USERS_URL = BASE_URL + ADDITIONAL_URL_PART;

    public UserClient() {
        super(USERS_URL);
    }

    @POST
    public Response createUser(JobUser user) {
                 client
                .type(APPLICATION_JSON_TYPE)
                .accept(APPLICATION_JSON_TYPE);
        return client.post(user);
    }

    @GET
    public Response getPartOfUsers(@QueryParam("part_number") String part_number) {
                client
                .type(APPLICATION_JSON_TYPE)
                .accept(APPLICATION_JSON_TYPE)
                .query("part_number", part_number);
        return client.get();
    }

    @GET
    public Response getUserById(int id) {
                 client
                .type(APPLICATION_JSON_TYPE)
                .accept(APPLICATION_JSON_TYPE)
                .path(id);
        return client.get();
    }

    @DELETE
    public Response deleteUser(int id) {
                client
                .type(APPLICATION_JSON_TYPE)
                .accept(APPLICATION_JSON_TYPE)
                .path(id);
        return client.delete();
    }

    @PUT
    public Response updateUserPut(int id, JobUser user) {
                client
                .type(APPLICATION_JSON_TYPE)
                .accept(APPLICATION_JSON_TYPE)
                .path(id);
        return client.put(user);
    }
}
