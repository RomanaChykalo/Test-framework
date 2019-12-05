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

    @POST
    public Response createUser(JobUser user) {
        log.info("Visit URL: " + USERS_URL);
        WebClient client = WebClient.create(USERS_URL, providers)
                .type(APPLICATION_JSON_TYPE)
                .accept(APPLICATION_JSON_TYPE);
        log.info("Create user with name: " + user.getName() + " and job: " + user.getJob());
        return client.post(user);
    }

    @GET
    public Response getPartOfUsers(@QueryParam("part_number") String part_number) {
        log.info("Visit URL: " + USERS_URL);
        WebClient client = WebClient.create(USERS_URL, providers)
                .type(APPLICATION_JSON_TYPE)
                .accept(APPLICATION_JSON_TYPE)
                .query("part_number", part_number);
        log.info("Get " + part_number + " part of users.....");
        return client.get();
    }

    @GET
    public Response getUserById(int id) {
        log.info("Visit URL: " + USERS_URL);
        WebClient client = WebClient.create(USERS_URL, providers)
                .type(APPLICATION_JSON_TYPE)
                .accept(APPLICATION_JSON_TYPE)
                .path(id);
        log.info("Get user with id: " + id);
        return client.get();
    }

    @DELETE
    public Response deleteUser(int id) {
        log.info("Visit URL: " + USERS_URL);
        WebClient client = WebClient.create(USERS_URL, providers)
                .type(APPLICATION_JSON_TYPE)
                .accept(APPLICATION_JSON_TYPE)
                .path(id);
        log.info("Delete user with id: " + id);
        return client.delete();
    }

    @PUT
    public Response updateUserPut(int id, JobUser user) {
        log.info("Visit URL: " + USERS_URL);
        WebClient client = WebClient.create(USERS_URL, providers)
                .type(APPLICATION_JSON_TYPE)
                .accept(APPLICATION_JSON_TYPE)
                .path(id);
        log.info("Update user with id: " + id + " with such info: " + user);
        return client.put(user);
    }
}
