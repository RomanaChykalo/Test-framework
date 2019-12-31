package integration;

import bo.LoginUserBO;
/*import bo.RegisterBO;
import bo.ResourceBO;
import bo.UserBO;*/
import io.restassured.http.ContentType;
import listener.AllureCustomListener;
import lombok.extern.log4j.Log4j;
import model.entity.JobUser;
import model.entity.User;
import model.entity.UserCredential;
import model.response.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Optional;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

@Log4j
@Listeners({AllureCustomListener.class})
public class ClientTest {
/*
    private static final String CSV_FILE_PATH = "src/test/resources/user_cred.csv";
    private static final String EMPTY_SPACE = "";
    private UserBO userBO = new UserBO();
    private RegisterBO registerBO = new RegisterBO();
    private LoginUserBO loginBO = new LoginUserBO();
    private ResourceBO resourseBO = new ResourceBO();

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
        Assert.assertEquals(validatableResponse.getData().id, 2, "ResourceRS id is not 2");
    }

    @Test(dataProvider = "userCredentials")
    public void createUserRegisterAndLoginTest(String email, String password) {
        JobUser jobUser = new JobUser("Olga", "accountant");
        CreateUserResponse userResponse = userBO.createUser(jobUser);
        Assert.assertEquals(userResponse.getJob(), jobUser.getJob(), "User job is not as expected: " + jobUser.getJob());
        Assert.assertEquals(userResponse.getName(), jobUser.getName(), "User name is not as expected: " + jobUser.getName());

        UserCredential userCredential = new UserCredential(email, password);
        UserRegisterResponse userRegisterResponse = registerBO.userRegister(userCredential);
        String token = userRegisterResponse.getToken();

        UserRegisterResponse userLogin = loginBO.loginUser(userCredential);
        String loginToken = userLogin.getToken();
        Assert.assertEquals(token, loginToken, "Register and login tokens must be the same.");
    }

    @Test
    public void loginUserUnsuccessfulTest() {
        UserCredential userCredential = new UserCredential("Olga@gmail.com");
        MissingPasswordResponse userResponse = loginBO.loginUserUnsuccessful(userCredential);
        Assert.assertEquals(userResponse.getError(), "Missing password", "Error message is not as expected.");
    }

    @Test
    public void findNonexistentUserTest() {
        User userResponse = userBO.getUserByIdUnsuccessful(888);
        Assert.assertNull(userResponse, "User exist but should not be.");
    }


    @Parameters(value = "userId")
    @Test
    public void getUserAndPartOfUsersTest(int userId) {
        User searchedUser = userBO.getUserById(userId).getData();
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
        User user = userBO.getUserById(userId).getData();
        Assert.assertEquals(user.getFirstName(), updatedUser.getName(), "User name is the same, user was not updated");
    }

    @Parameters(value = "userId")
    @Test
    public void deleteUserTest(int userId) {
        String deleteUser = userBO.deleteUser(userId);
        if (deleteUser.isEmpty()) {
            User user = userBO.getUserById(userId).getData();
            Assert.assertNull(user, "User exist, but must be deleted");
        } else {
            log.info("User with id: " + userId + " cannot be deleted because it doesn't exist");
        }
    }

    @Parameters(value = "userId")
    @Test
    public void getExistingResourceById(int resourceId) {
        Resource resourceRS = resourseBO.getResourceById(resourceId);
        Assert.assertEquals(resourceRS.getId(), resourceId, "Finded resourceRS id is not as expected");
    }

    @Test
    public void getNotExistingResourceById() {
        Resource resourceRS = resourseBO.getNonExistentResourceById(1111);
        Assert.assertNull(resourceRS, "Resource was find unexpectedly");
    }

    @Test
    public void getAllResources() {
        ManyResourcesResponse resource = resourseBO.getAllResources();
        Assert.assertNotNull(resource.getData(), "ResourceRS id is not as expected");
    }

    @Test
    public void updateUser() {
        UpdateUserResponse updatedUser = userBO.updateUser(2, new JobUser("Volodia", "developer"));
        User user = userBO.getUserById(2).getData();
        Assert.assertEquals(user.getFirstName(), updatedUser.getName(), "User name is the same, user was not updated");
    }

    @DataProvider
    private Object[][] userCredentials() {
        return new Object[][]{
                {"eve.holt@reqres.in", "pistol"},
                {"megogo@reqres.in", "pistol"},
                {"olisia@reqres.in", "humana"},
                {"rasmus@reqres.in", "humana"}
        };
    }

    @BeforeSuite
    private void writeDataProviderInfoToCSV() throws IOException {
        Object[][] userCredentials = userCredentials();

        FileWriter out = new FileWriter(new File(CSV_FILE_PATH));
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader("email", "password"))) {
            Arrays.stream(userCredentials).forEach((credention) -> {
                try {
                    printer.printRecord(credention);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @AfterSuite
    private void cleanCSVFile() {
        try {
            FileWriter writer = new FileWriter(new File(CSV_FILE_PATH));
            writer.write(EMPTY_SPACE);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

@Test
    void loginTest(){
    LoginUserBO loginUserBO = new LoginUserBO();
    UserCredential userCredential=new UserCredential("eve.holt@reqres.in", "cityslicka");
    loginUserBO.loginUser(userCredential);
}
}
