package model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceRootElementResponse {
    @NonNull
    @JsonProperty
    public int id;
    @NonNull
    @JsonProperty
    public String name;
    @NonNull
    @JsonProperty
    public int year;
    @NonNull
    @JsonProperty
    public String color;
    @NonNull
    @JsonProperty(value = "pantone_value")
    public String pantoneValue;
}
