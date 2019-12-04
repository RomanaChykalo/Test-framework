package model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ManyEntityResponse<T> {
    @JsonProperty
    protected int page;
    @JsonProperty
    protected int per_page;
    @JsonProperty
    protected int total;
    @JsonProperty
    protected int total_pages;
    @JsonProperty
    private List<T> data;
}
