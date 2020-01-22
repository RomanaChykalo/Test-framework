package bo;

import client.UserClient;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import model.entity.JobUser;
import model.entity.User;
import model.response.CreateUserResponse;
import model.response.ManyUsersResponse;
import model.response.UpdateUserResponse;
import model.response.UserRS;
import org.testng.Assert;

import javax.ws.rs.core.Response;

@Log4j
public class UserBO {
    private UserClient userClient = new UserClient();

    @Step("Create user with info {jobUser}")
    public CreateUserResponse createUser(JobUser jobUser) {
        Response createUserResponse = userClient.createUser(jobUser);
        Assert.assertEquals(createUserResponse.getStatus(), Response.Status.CREATED.getStatusCode(), "Response status-code is not: " + Response.Status.CREATED);
        return createUserResponse.readEntity(CreateUserResponse.class);
    }

    @Step("Get {part_number} part of users.")
    public ManyUsersResponse getPartOfUsers(String part_number) {
        Response response = userClient.getPartOfUsers(part_number);
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode(), "Response status-code is not: " + Response.Status.OK);
        return response.readEntity(ManyUsersResponse.class);
    }

    @Step("Find user with id: {id}")
    public UserRS getUserById(int id, Response.Status code) {
        Response response = userClient.getUserById(id);
        Assert.assertEquals(response.getStatus(), code.getStatusCode(), "Response status-code is not: " + Response.Status.OK);
        return response.readEntity(UserRS.class);
    }

    @Step("Delete user with id: {id}")
    public String deleteUser(int id) {
        Response response = userClient.deleteUser(id);
        Assert.assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode(), "Response status-code is not: " + Response.Status.NO_CONTENT);
        Assert.assertTrue(response.hasEntity());
        return response.readEntity(String.class);
    }

    @Step("Update user with id: {id} using info {user}")
    public UpdateUserResponse updateUser(int id, JobUser user) {
        Response response = userClient.updateUserPut(id, user);
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode(), "Response status-code is not: " + Response.Status.OK);
        return response.readEntity(UpdateUserResponse.class);
    }

    @Step("Find user with id: {id}")
    public User getUserByIdUnsuccessful(int id) {
        Response response = userClient.getUserById(id);
        Assert.assertEquals(response.getStatus(), Response.Status.NOT_FOUND.getStatusCode(), "Response status-code is not: " + Response.Status.NOT_FOUND);
        return response.readEntity(UserRS.class).getData();
    }
}
