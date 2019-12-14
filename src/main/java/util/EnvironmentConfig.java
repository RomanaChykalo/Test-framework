package util;

import exception.AutomationException;
import lombok.extern.log4j.Log4j;

import java.util.Map;

import static util.PropertyUtil.getConfigList;

@Log4j
public class EnvironmentConfig {
    private static Map<String, String> configList;

    private static Map<String, String> getConfig() {
        if (configList == null) {
            configList = getConfigList();
        }
        return configList;
    }

    public static String getBaseUrlFromConfig() {
        String envToUse = System.getProperty("env");
        if (getConfig().get(envToUse) == null) {
            throw new AutomationException("Environment is not found in existing environment list, need enter one of : " + configList.keySet());
        }
        if (envToUse.isEmpty()) {
            throw new AutomationException("Environment name can't be empty, define -Denv option");
        }
        return configList.get(envToUse);
    }
}
