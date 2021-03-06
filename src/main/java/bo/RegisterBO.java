package bo;

import client.RegisterClient;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import model.entity.UserCredential;
import model.response.MissingPasswordResponse;
import model.response.UserRegisterResponse;
import org.testng.Assert;

import javax.ws.rs.core.Response;

@Log4j
public class RegisterBO {
    private RegisterClient registerClient = new RegisterClient();

    @Step("Register user with credential {userCredential}")
    public UserRegisterResponse userRegister(UserCredential userCredential) {
        Response response = registerClient.registerUser(userCredential);
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode(), "Response status-code is not: " + Response.Status.OK);
        return response.readEntity(UserRegisterResponse.class);
    }
    @Step("Register user with not full credential {userCredential}")
    public MissingPasswordResponse registerUserUnsuccessful(UserCredential userCredential) {
        Response response = registerClient.registerUser(userCredential);
        Assert.assertEquals(response.getStatus(), Response.Status.BAD_REQUEST.getStatusCode(), "Response status-code is not: " + Response.Status.BAD_REQUEST);
        log.info("Get error message: " + response.readEntity(MissingPasswordResponse.class).getError());
        return response.readEntity(MissingPasswordResponse.class);
    }
}
