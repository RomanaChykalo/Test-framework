package model.response;

import org.codehaus.jackson.annotate.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.entity.User;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManyUsersResponse extends ManyEntityResponse<User> {
    @JsonProperty
    private List<User> data = null;
}
