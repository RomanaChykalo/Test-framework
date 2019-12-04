package bo;

import client.UserClient;
import lombok.extern.log4j.Log4j2;
import model.entity.JobUser;
import model.entity.User;
import model.response.CreateUserResponse;
import model.response.ManyEntityResponse;
import model.response.ManyUsersResponse;
import model.response.UpdateUserResponse;
import org.testng.Assert;
import util.ObjectMapper;

import javax.rmi.CORBA.Util;
import javax.ws.rs.core.Response;

@Log4j2
public class UserBO {
    private UserClient userClient = new UserClient();

    public CreateUserResponse createUser(JobUser jobUser) {
        Response createUserResponse = userClient.createUser(jobUser);
        Assert.assertEquals(createUserResponse.getStatus(), Response.Status.CREATED.getStatusCode(), "Response status-code is not: " + Response.Status.CREATED);
        return ObjectMapper.mapToEntity(createUserResponse, CreateUserResponse.class);
    }

    public ManyUsersResponse getPartOfUsers(String part_number) {
        Response response = userClient.getPartOfUsers(part_number);
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode(), "Response status-code is not: " + Response.Status.OK);
        return response.readEntity(ManyUsersResponse.class);
    }

    public User getUserById(int id) {
        Response response = userClient.getUserById(id);
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode(), "Response status-code is not: " + Response.Status.OK);
        return ObjectMapper.mapToEntity(response,User.class);
    }

    public int deleteUser(int id) {
        Response response = userClient.deleteUser(id);
        Assert.assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode(), "Response status-code is not: " + Response.Status.NO_CONTENT);
        return 1;
    }

    public UpdateUserResponse updateUser(int id, JobUser user) {
        Response response = userClient.updateUserPut(id, user);
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode(), "Response status-code is not: " + Response.Status.OK);
        return response.readEntity(UpdateUserResponse.class);
    }
}
