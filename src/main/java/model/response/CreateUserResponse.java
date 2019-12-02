package model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {
    @JsonProperty
    private String name;
    @JsonProperty
    private String job;
    @JsonProperty
    private String id;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonProperty
    private LocalDate createdAt;
}
