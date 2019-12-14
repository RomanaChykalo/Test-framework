package bo;

import client.ResourceClient;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import model.response.Resource;
import model.response.ResourceRS;
import model.response.ManyResourcesResponse;
import org.testng.Assert;

import javax.ws.rs.core.Response;
@Log4j
public class ResourceBO {
    private ResourceClient resourceClient = new ResourceClient();

    @Step("Get ResourceRS with id {id}")
    public Resource getResourceById(int id) {
        Response response = resourceClient.getResourceById(id);
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode(), "Response status-code is not: " + Response.Status.OK);
        Resource resource = response.readEntity(ResourceRS.class).getData();
        log.info("Get response body:  "+resource);
        return resource;

    }
    @Step("Get all resources")
    public ManyResourcesResponse getAllResources() {
        Response response = resourceClient.getAllResources();
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode(), "Response status-code is not: " + Response.Status.OK);
        ManyResourcesResponse manyResourcesResponse = response.readEntity(ManyResourcesResponse.class);
        log.info("Get response body:  "+manyResourcesResponse);
        return manyResourcesResponse;
    }
    @Step("Get nonexistent resource with id {id}")
    public Resource getNonExistentResourceById(int id) {
        Response response = resourceClient.getResourceById(id);
        Assert.assertEquals(response.getStatus(), Response.Status.NOT_FOUND.getStatusCode(), "Response status-code is not: " + Response.Status.NOT_FOUND);
        Resource resource = response.readEntity(ResourceRS.class).getData();
        log.info("Get response body:  "+resource);
        return resource;
    }
}
