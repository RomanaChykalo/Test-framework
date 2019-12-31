package client;

/*import org.codehaus.jackson.jaxrs.JacksonJsonProvider;*/
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import util.EnvironmentConfig;

import java.util.ArrayList;
import java.util.List;
import org.apache.cxf.ext.logging.*;
import static util.PropertyUtil.getConfigList;

public abstract class AbstractClient {
     static final String BASE_URL = EnvironmentConfig.getBaseUrlFromConfig();
     protected WebClient client;
     List<Object> providers = new ArrayList<>();

    protected AbstractClient(String url){
        providers.add(new JacksonJsonProvider());
        client = WebClient.create(url, providers);
        ClientConfiguration config = WebClient.getConfig(client);
        config.getInInterceptors().add(new LoggingInInterceptor());
          config.getOutInterceptors().add(new LoggingOutInterceptor());

    }
}
