package client;

import lombok.extern.log4j.Log4j;
import model.entity.UserCredential;

import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Log4j
public class LoginUserClient extends AbstractClient {
    private static final String ADDITIONAL_URL_PART = "login";
    private static final String LOGIN_URL = BASE_URL + ADDITIONAL_URL_PART;

    public LoginUserClient() {
        super(LOGIN_URL);
    }

    @POST
    public Response loginUser(UserCredential userCredential) {
        client.accept(MediaType.APPLICATION_JSON_TYPE).type(MediaType.APPLICATION_JSON_TYPE);
        Response response = client.post(userCredential);
        return response;
    }
}
