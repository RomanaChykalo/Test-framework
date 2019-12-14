package model.entity;

import org.codehaus.jackson.annotate.JsonProperty;
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
