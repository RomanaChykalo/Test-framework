package model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManyResourcesResponse extends ManyEntityResponse<Resource> {
    @JsonProperty
    private List<Resource> data = null;
}
