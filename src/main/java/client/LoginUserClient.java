package client;

import lombok.extern.log4j.Log4j;
import model.entity.UserCredential;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
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
   /* @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)*/
    public Response loginUser(UserCredential userCredential) {
        /* log.info("Visit URL: " + LOGIN_URL);*/
        client
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .type(MediaType.APPLICATION_JSON_TYPE);
       /* log.info("Execute user login using credential: " + userCredential.getEmail() + " and password: " + userCredential.getPassword());*/
        Response response = client.post(userCredential);
        return response;
    }
}
