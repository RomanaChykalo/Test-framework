package model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class UserCredential implements Serializable {
    @JsonProperty
    private String email;
    @JsonProperty
    private String password;

    public UserCredential(String email) {
        this.email = email;
    }
}
