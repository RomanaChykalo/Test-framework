package client;

import lombok.extern.log4j.Log4j2;
import model.entities.UserCredential;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Log4j2
public class LoginUserClient extends AbstractClient {
    private static final String ADDITIONAL_URL_PART = "login";
    private static final String LOGIN_URL = BASE_URL + ADDITIONAL_URL_PART;

    @POST
    public Response loginUser(UserCredential userCredential) {
        log.info("Visit URL: " + LOGIN_URL);
        WebClient client = WebClient
                .create(LOGIN_URL, providers)
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .type(MediaType.APPLICATION_JSON_TYPE);
        log.info("Execute user login using credential " + userCredential.getEmail(), userCredential.getPassword());
        return client.post(userCredential);
    }
}
