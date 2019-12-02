package util;

import client.RegisterClient;
import model.entity.UserCredential;
import model.response.UserRegisterResponse;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {
        private static Map<String, String> configList = new PropertyUtil().getInfoFromPropertyFile();

        private Map<String, String> getInfoFromPropertyFile() {
            Properties prop = new Properties();
            try (InputStream input = getClass().getClassLoader().getResourceAsStream("env.properties")) {
                prop.load(input);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            configList = new HashMap<>();
            configList.put("env_prod", prop.getProperty("env_prod"));
            configList.put("env_test", prop.getProperty("env_test"));
            return configList;
        }

        public static Map<String, String> getConfigList() {
            return configList;
        }

    public static void main(String[] args) {
        Response response = new RegisterClient().registerUser(new UserCredential("eve.holt@reqres.in", "pistol"));
        System.out.println(response.readEntity(UserRegisterResponse.class));
    }
}
