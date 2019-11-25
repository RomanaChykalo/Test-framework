package model.responses;

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
public class ManyEntityResponse {
    @JsonProperty
    private int page;
    @JsonProperty
    private int per_page;
    @JsonProperty
    private int total;
    @JsonProperty
    private int total_pages;
    @JsonProperty(value ="data")
    private List<? extends Object> entities;
}
