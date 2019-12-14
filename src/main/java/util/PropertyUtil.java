package util;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Log4j
public class PropertyUtil {
    private static Map<String, String> configList = new PropertyUtil().getInfoFromPropertyFile();

    public static Map<String, String> getConfigList() {
        return configList;
    }

    private Map<String, String> getInfoFromPropertyFile() {
        Properties prop = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("env.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
        configList = new HashMap<>();
        configList.put("env_prod", prop.getProperty("env_prod"));
        configList.put("env_test", prop.getProperty("env_test"));
        return configList;
    }
}
