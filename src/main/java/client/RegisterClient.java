package client;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import java.util.logging.Logger;

import static javax.ws.rs.core.MediaType.*;

/*@Log4j
public class RegisterClient extends AbstractClient {
    private static final String ADDITIONAL_URL_PART = "register";
    private static final String REGISTER_URL = BASE_URL + ADDITIONAL_URL_PART;

    @POST
    @Interceptors(LoggingIntercept.class)
    public Response registerUser(UserCredential userCredential) {
        log.info("Visit URL: " + REGISTER_URL);
        WebClient client = WebClient
                .create(REGISTER_URL, providers)
                .accept(APPLICATION_JSON_TYPE)
                .type(APPLICATION_JSON_TYPE);
        log.info("Register user using credential: email " + userCredential.getEmail() + ", and user password: " + userCredential.getPassword());
        return client.post(userCredential);
    }
}*/
