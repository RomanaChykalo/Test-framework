import io.restassured.http.ContentType;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ValidatableResponse;
import model.entity.Resource;
import model.response.SingleResourceResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.ObjectMapper;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class UserClientTest {

    @Test
    public static void createUserTest() {
        /*JobUser jobUser = new JobUser("Ihor", "sales-manager");
        Response createUserResponse = userClient.createUser(jobUser);
        Assert.assertEquals(createUserResponse.getStatus(), Response.Status.CREATED.getStatusCode());
        CreateUserResponse userResponse = ObjectMapper.mapToEntity(createUserResponse, CreateUserResponse.class);
        Assert.assertEquals(userResponse.getName(),jobUser.getName());
        Assert.assertEquals(userResponse.getJob(),jobUser.getJob());*/
    }

    //  Rest-Assured
    @Test
    public void loginAndGetOneResourse() {
        Map<String, String> request = new HashMap<>();
        request.put("email", "eve.holt@reqres.in");
        request.put("password", "cityslicka");

        given()
                .contentType(ContentType.JSON)
                .body(request)
                .post("https://reqres.in/api/login")
                .then()
                .assertThat()
                .statusCode(200);

        SingleResourceResponse validatableResponse =   get("https://reqres.in/api/unknown/2")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(SingleResourceResponse.class);
        System.out.println(validatableResponse);
    }
}
