package model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.entity.User;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ManyUsersResponse extends ManyEntityResponse<User> {
    @JsonProperty("data")
    private List<User> data = null;
}
