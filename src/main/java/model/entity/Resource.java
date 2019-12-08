package model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "data")
public class Resource{
    @JsonProperty
    private int id;
    @JsonProperty
    private String name;
    @JsonProperty
    private int year;
    @JsonProperty
    private String color;
    @JsonProperty("pantoneValue")
    private String pantone_value;
}
