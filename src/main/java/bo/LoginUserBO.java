package bo;

import client.LoginUserClient;
import client.RegisterClient;
import model.entity.UserCredential;
import model.response.UserRegisterResponse;
import org.testng.Assert;

import javax.ws.rs.core.Response;

public class LoginUserBO {
    private LoginUserClient loginClient = new LoginUserClient();

    public UserRegisterResponse userRegister(UserCredential userCredential) {
        Response response = loginClient.loginUser(userCredential);
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode(), "Response status-code is not: " + Response.Status.OK);
        return response.readEntity(UserRegisterResponse.class);
    }
}
