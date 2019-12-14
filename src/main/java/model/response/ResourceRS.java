package model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
/*@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "data")*/
public class ResourceRS {
    @JsonProperty
    private Resource data;
}
