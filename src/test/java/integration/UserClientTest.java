package integration;

import bo.LoginUserBO;
import bo.RegisterBO;
import bo.ResourseBO;
import bo.UserBO;
import io.restassured.http.ContentType;
import lombok.extern.log4j.Log4j2;
import model.entity.JobUser;
import model.entity.Resource;
import model.entity.User;
import model.entity.UserCredential;
import model.response.*;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

@Log4j2
public class UserClientTest {
    private UserBO userBO = new UserBO();
    private RegisterBO registerBO = new RegisterBO();
    private LoginUserBO loginBO = new LoginUserBO();
    private ResourseBO resourseBO = new ResourseBO();

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
                .statusCode(HttpStatus.SC_OK);

        SingleResourceResponse validatableResponse = get("https://reqres.in/api/unknown/2")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(SingleResourceResponse.class);
        Assert.assertEquals(validatableResponse.getData().id, 2, "Resource id is not 2");
    }

    @Test
    public void createUserRegisterAndLoginTest() {
        JobUser jobUser = new JobUser("Olga", "accountant");
        CreateUserResponse userResponse = userBO.createUser(jobUser);
        Assert.assertEquals(userResponse.getJob(), jobUser.getJob(), "User job is not as expected: " + jobUser.getJob());
        Assert.assertEquals(userResponse.getName(), jobUser.getName(), "User name is not as expected: " + jobUser.getName());

        UserCredential userCredential = new UserCredential("eve.holt@reqres.in", "pistol");
        UserRegisterResponse userRegisterResponse = registerBO.userRegister(userCredential);
        String token = userRegisterResponse.getToken();

        UserRegisterResponse userLogin = loginBO.loginUser(userCredential);
        String loginToken = userLogin.getToken();
        Assert.assertEquals(token, loginToken, "Register and login tokens must be the same.");
    }

    @Parameters(value = "userId")
    @Test
    public void getUserAndPartOfUsersTest(int userId) {
        User searchedUser = userBO.getUserById(userId);
        User userFromPage;
        for (int i = 1; i < 3; i++) {
            ManyUsersResponse partOfUsers = userBO.getPartOfUsers(String.valueOf(i));
            List<User> users = partOfUsers.getData();
            Optional user = users.stream().filter(it -> it.getId() == userId).findAny();
            if (user.isPresent()) {
                userFromPage = (User) user.get();
                log.info("User with id: " + userId + " is found on " + i + " page.");
                Assert.assertEquals(searchedUser, userFromPage, "Searched user is not as expected");
            }
        }
    }

    @Parameters(value = "userId")
    @Test
    public void updateUserTest(int userId) {
        UpdateUserResponse updatedUser = userBO.updateUser(userId, new JobUser("Volodia", "developer"));
        User user = userBO.getUserById(userId);
        Assert.assertEquals(user.getFirst_name(), updatedUser.getName(), "User name is the same, user was not updated");
    }

    @Parameters(value = "userId")
    @Test
    public void deleteUserTest(int userId) {
        int i = userBO.deleteUser(userId);
        if (i != 0) {
            User user = userBO.getUserById(userId);
            Assert.assertNull(user, "User exist< but must be deleted");
        } else {
            log.info("User with id: " + userId + " cannot be deleted because it doesn't exist");
        }
    }

    @Parameters(value = "userId")
    @Test
    public void getExistingResourceById(int resourceId) {
        Resource resource = resourseBO.getResourceById(resourceId);
        Assert.assertEquals(resource.getId(),resourceId,"Finded resource id is not as expected");
    }

    @Test
    public void getNotExistingResourceById() {
        Resource resource = resourseBO.getNonExistentResourceById(1111);
        Assert.assertNull(resource,"Resourse was find unexpectedly");
    }
    @Test
    public void getAllResources() {
        ManyResourcesResponse resource = resourseBO.getAllResources();
        Assert.assertFalse(resource.getData().isEmpty(),"Finded resource id is not as expected");
    }

}
