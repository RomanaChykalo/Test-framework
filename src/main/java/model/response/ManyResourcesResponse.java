package model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.entity.Resource;
import model.entity.User;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ManyResourcesResponse extends ManyEntityResponse<Resource> {
    @JsonProperty("data")
    private List<Resource> data = null;
}
