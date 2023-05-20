package org.hk.doghub.data.content.generator.tip.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@ToString
public class Tip {

    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    private String title;

    @NotNull
    @Size(min = 2, max = 1024)
    @NotBlank
    private String content;

    @URL
    private String moreInfo;
}
