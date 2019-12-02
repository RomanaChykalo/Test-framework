package util;

import exception.AutomationException;

import java.util.Map;

import static util.PropertyUtil.getConfigList;

public class EnvironmentConfig {
   private static Map<String, String> configList;

   /* protected static final String BASE_URL = configList.get(System.getProperty("env"));
    */
   private static Map<String, String> getConfig() {
      if (configList == null) {
         configList = getConfigList();
      }
      return configList;
   }

   public static String getBaseUrlFromConfig() {
      String envToUse = System.getProperty("env");
      if (envToUse.isEmpty()) {
         throw new AutomationException("Environment name can't be empty, define -Denv option");
      }
      if (getConfig().get(envToUse) == null) {
         throw new AutomationException("Environment is not found in existing environment list, need enter one of : " + configList.keySet());
      }
      return configList.get(System.getProperty("env"));
   }
}
