package model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRegisterResponse {
    @JsonProperty
    private int id;
    @JsonProperty
    private String token;

    public UserRegisterResponse(String token) {
        this.token = token;
    }
}
