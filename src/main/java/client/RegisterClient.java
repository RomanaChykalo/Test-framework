package client;

import lombok.extern.log4j.Log4j;
import model.entity.UserCredential;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

@Log4j
public class RegisterClient extends AbstractClient {
    private static final String ADDITIONAL_URL_PART = "register";
    private static final String REGISTER_URL = BASE_URL + ADDITIONAL_URL_PART;

    public RegisterClient() {
        super(REGISTER_URL);
    }

    @POST
    public Response registerUser(UserCredential userCredential) {
        client.accept(APPLICATION_JSON_TYPE).type(APPLICATION_JSON_TYPE);
        return client.post(userCredential);
    }
}
