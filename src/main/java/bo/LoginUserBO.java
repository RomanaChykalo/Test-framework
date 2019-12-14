package bo;

import client.LoginUserClient;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import model.entity.UserCredential;
import model.response.MissingPasswordResponse;
import model.response.UserRegisterResponse;
import org.testng.Assert;

import javax.ws.rs.core.Response;


@Log4j
public class LoginUserBO {
    private LoginUserClient loginClient = new LoginUserClient();

    @Step("Login user with credential {userCredential}")
    public UserRegisterResponse loginUser(UserCredential userCredential) {
        Response response = loginClient.loginUser(userCredential);
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode(), "Response status-code is not: " + Response.Status.OK);
        UserRegisterResponse userRegisterResponse = response.readEntity(UserRegisterResponse.class);
        log.info("Get response:  "+userRegisterResponse);
        return userRegisterResponse;
    }

    @Step("Login user with not full credential {userCredential}")
    public MissingPasswordResponse loginUserUnsuccessful(UserCredential userCredential) {
        Response response = loginClient.loginUser(userCredential);
        Assert.assertEquals(response.getStatus(), Response.Status.BAD_REQUEST.getStatusCode(), "Response status-code is not: " + Response.Status.BAD_REQUEST);
        log.info("Get error message: " + response.readEntity(MissingPasswordResponse.class).getError());
        MissingPasswordResponse registerResponse = response.readEntity(MissingPasswordResponse.class);
        log.info("Get response:  "+registerResponse);
        return registerResponse;
    }
}
