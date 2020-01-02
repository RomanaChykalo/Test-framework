package client;

/*import org.codehaus.jackson.jaxrs.JacksonJsonProvider;*/

import lombok.extern.log4j.Log4j;
import org.apache.cxf.common.logging.Log4jLogger;
import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import util.EnvironmentConfig;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Log4j
public abstract class AbstractClient {
    static final String BASE_URL = EnvironmentConfig.getBaseUrlFromConfig();
    protected WebClient client;

    AbstractClient(String url) {
        LogUtils.setLoggerClass(org.apache.cxf.common.logging.Log4jLogger.class);
        List<Object> providers = new ArrayList<>();
        providers.add(new JacksonJsonProvider());
        client = WebClient.create(url, providers);
        addLoggingInterceptors(client);
    }

    private void addLoggingInterceptors(WebClient client) {
        LogUtils.setLoggerClass(org.apache.cxf.common.logging.Log4jLogger.class);
        ClientConfiguration config = WebClient.getConfig(client);
        LoggingInInterceptor loggingInInterceptor = new LoggingInInterceptor();
        loggingInInterceptor.setPrettyLogging(true);
        LoggingOutInterceptor loggingOutInterceptor = new LoggingOutInterceptor();
        loggingOutInterceptor.setPrettyLogging(true);
        config.getInInterceptors().add(loggingInInterceptor);
        config.getOutInterceptors().add(loggingOutInterceptor);
    }
}
