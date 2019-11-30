package util;

import exception.AutomationException;

import java.util.Map;

import static util.PropertyUtil.getConfigList;

public class EnvironmentConfig {
    private static Map<String, String> configList;
   /* protected static final String BASE_URL = configList.get(System.getProperty("env"));
*/
    private static Map<String, String> getConfig() {
        if (configList==null) {
            configList = getConfigList();
        }
        return configList;
    }

    public static String getBaseUrlFromConfig() {
        String envToUse = System.getProperty("env");
        if (envToUse.isEmpty()) {
            throw new AutomationException("Environment name can't be empty, define -Denv parameter");
        }
        if(getConfig().get(envToUse)==null){
            throw new AutomationException("Environment is not found, need enter one of existing: "+ configList.keySet());
        }
        return configList.get(System.getProperty("env"));
    }
}
