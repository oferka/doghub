package org.hk.doghub.data.content.generator.dog.dogapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class DogApiListAllBreedsResponse {

    private Map<String, List<String>> message;

    private String status;
}
