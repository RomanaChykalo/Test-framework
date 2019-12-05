package bo;

import client.ResourceClient;
import io.qameta.allure.Step;
import model.entity.Resource;
import model.response.ManyEntityResponse;
import model.response.ManyResourcesResponse;
import org.testng.Assert;
import util.ObjectMapper;

import javax.swing.text.html.parser.Entity;
import javax.ws.rs.core.Response;
import java.util.Objects;

public class ResourseBO {
    private ResourceClient resourceClient = new ResourceClient();

    @Step("Get Resource with id {0}")
    public Resource getResourceById(int id) {
        Response response = resourceClient.getResourceById(id);
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode(), "Response status-code is not: " + Response.Status.OK);
        return ObjectMapper.mapToEntity(response,Resource.class);
    }
    @Step("Get all resources")
    public ManyResourcesResponse getAllResources() {
        Response response = resourceClient.getAllResources();
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode(), "Response status-code is not: " + Response.Status.OK);
        return response.readEntity(ManyResourcesResponse.class);
    }
    @Step("Get nonexistent resource with id {0}")
    public Resource getNonExistentResourceById(int id) {
        Response response = resourceClient.getResourceById(id);
        Assert.assertEquals(response.getStatus(), Response.Status.NOT_FOUND.getStatusCode(), "Response status-code is not: " + Response.Status.NOT_FOUND);
        return null;
    }
}
