package util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.entities.Resource;
import model.entities.User;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

public class ObjectMapper {
    public static <T> T mapToEntity(Response response, Class<T> classType) {
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (classType.equals(User.class) || classType.equals(Resource.class)) {
            objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
                    .registerModule(new ParameterNamesModule())
                    .registerModule(new Jdk8Module())
                    .registerModule(new JavaTimeModule());
        }
        T entity = null;
        try {
            entity = objectMapper.readValue((InputStream) response.getEntity(), classType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity;
    }
}
