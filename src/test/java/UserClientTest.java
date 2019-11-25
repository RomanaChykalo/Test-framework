import client.UserClient;
import io.qameta.allure.Step;
import model.entities.JobUser;
import model.responses.CreateUserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.ObjectMapper;

import javax.ws.rs.core.Response;

public class UserClientTest {
    public static UserClient userClient = new UserClient();

    @Test
    public static void createUserTest() {
        JobUser jobUser = new JobUser("Ihor", "sales-manager");
        Response createUserResponse = userClient.createUser(jobUser);
        Assert.assertEquals(createUserResponse.getStatus(), 201);
        CreateUserResponse userResponse = ObjectMapper.mapToEntity(createUserResponse, CreateUserResponse.class);
        System.out.println(userResponse);
    }
}
