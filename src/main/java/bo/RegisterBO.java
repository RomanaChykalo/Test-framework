package bo;

import client.RegisterClient;
import model.entity.UserCredential;
import model.response.UserRegisterResponse;
import org.testng.Assert;

import javax.ws.rs.core.Response;

public class RegisterBO {
    private RegisterClient registerClient = new RegisterClient();

    public UserRegisterResponse userRegister(UserCredential userCredential) {
        Response response = registerClient.registerUser(userCredential);
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode(), "Response status-code is not: " + Response.Status.OK);
        return response.readEntity(UserRegisterResponse.class);
    }
}
