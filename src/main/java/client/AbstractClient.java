package client;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import util.EnvironmentConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static util.PropertyUtil.getConfigList;

public abstract class AbstractClient {
   // private static Map<String, String> configList = getConfigList();
     static final String BASE_URL = EnvironmentConfig.getBaseUrlFromConfig();
     List<Object> providers = new ArrayList<>();

    {
        providers.add(new JacksonJsonProvider());
    }
}
