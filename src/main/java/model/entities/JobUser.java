package model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobUser {
    @JsonProperty
    private String name;
    @JsonProperty
    private String job;
}
