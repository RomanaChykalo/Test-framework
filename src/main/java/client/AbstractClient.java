package client;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static util.PropertyUtil.getConfigList;

public abstract class AbstractClient {
    private static Map<String, String> configList = getConfigList();
    protected static final String BASE_URL = configList.get(System.getProperty("env"));
    protected List<Object> providers = new ArrayList<>();

    {
        providers.add(new JacksonJsonProvider());
    }
}
