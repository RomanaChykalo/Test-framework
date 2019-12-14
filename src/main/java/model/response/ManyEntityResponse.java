package model.response;

/*import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;*/
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ManyEntityResponse<T> {
    @JsonProperty
    protected int page;
    @JsonProperty(value = "per_page")
    protected int perPage;
    @JsonProperty
    protected int total;
    @JsonProperty("total_pages")
    protected int totalPages;
    @JsonProperty
    private List<T> data;
}
