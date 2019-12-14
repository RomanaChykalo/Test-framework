package model.response;

import org.codehaus.jackson.annotate.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;/*
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;*/
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResponse {
    @JsonProperty
    private String name;
    @JsonProperty
    private String job;
 //   @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonProperty
    private String updatedAt;
}
