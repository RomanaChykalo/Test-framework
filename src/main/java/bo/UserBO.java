package bo;

import client.UserClient;
import lombok.extern.log4j.Log4j2;
import model.entity.JobUser;
import model.response.CreateUserResponse;
import model.response.ManyEntityResponse;
import org.testng.Assert;
import util.ObjectMapper;

import javax.ws.rs.core.Response;
@Log4j2
public class UserBO {
   private UserClient userClient = new UserClient();

   public CreateUserResponse createUser(JobUser jobUser) {
      Response createUserResponse = userClient.createUser(jobUser);
      Assert.assertEquals(createUserResponse.getStatus(), Response.Status.CREATED.getStatusCode(), "Calling assert for response status-code: "+ Response.Status.CREATED.getStatusCode());
      return ObjectMapper.mapToEntity(createUserResponse, CreateUserResponse.class);
   }

   public ManyEntityResponse getPartOfUsers( String part_number) {
      Response createUserResponse = userClient.getPartOfUsers(part_number);
      Assert.assertEquals(createUserResponse.getStatus(), Response.Status.OK.getStatusCode(), "Calling assert for response status-code:"+ Response.Status.CREATED.getStatusCode();
      return createUserResponse.readEntity(ManyEntityResponse.class);
   }
}
