package model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "data")
public class User {
    @JsonProperty
    private int id;
    @JsonProperty
    private String email;
    @JsonProperty
    private String first_name;
    @JsonProperty
    private String last_name;
    @JsonProperty
    private String avatar;
}
