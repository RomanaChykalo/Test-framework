package bo;

import client.ResourceClient;
import model.entity.Resource;
import model.response.ManyEntityResponse;
import org.testng.Assert;

import javax.ws.rs.core.Response;

public class ResourseBO {
    private ResourceClient resourceClient = new ResourceClient();

    public Resource getResourceById(int id) {
        Response response = resourceClient.getResourceById(id);
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode(), "Response status-code is not: " + Response.Status.OK);
        return response.readEntity(Resource.class);
    }
    public ManyEntityResponse getAllResources() {
        Response response = resourceClient.getAllResources();
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode(), "Response status-code is not: " + Response.Status.OK);
        return response.readEntity(ManyEntityResponse.class);
    }
}
