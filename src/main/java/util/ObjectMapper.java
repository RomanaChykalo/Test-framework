package util;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

public class ObjectMapper {
    /*public static <T> T mapToEntity(Response response, Class<T> classType) {
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
       *//* if (classType.equals(User.class) || classType.equals(ResourceRS.class)) {
            objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
                    .registerModule(new ParameterNamesModule())
                    .registerModule(new Jdk8Module())
                    .registerModule(new JavaTimeModule());
        }*//*
        T entity = null;
        try {
            entity = objectMapper.readValue((InputStream) response.getEntity(), classType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity;
    }*/
}
