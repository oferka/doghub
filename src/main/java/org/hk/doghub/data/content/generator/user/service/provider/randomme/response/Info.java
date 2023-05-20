package org.hk.doghub.data.content.generator.user.service.provider.randomme.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Info {

    private String seed;

    private int results;

    private int page;

    private String version;
}
