package org.hk.doghub.data.content.generator.user.randomme.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class RandomMeResponse {

    private List<Result> results;
    private Info info;
}
