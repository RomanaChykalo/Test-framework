package model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Resource {
    @JsonProperty
    private int id;
    @JsonProperty
    private String name;
    @JsonProperty
    private int year;
    @JsonProperty
    private String color;
    @JsonProperty("pantone_value")
    private String pantoneValue;
}
