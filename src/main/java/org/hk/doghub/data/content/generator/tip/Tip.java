package org.hk.doghub.data.content.generator.tip;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;
import org.hk.doghub.data.content.generator.ProvidedObject;

@Getter
@Setter
@ToString
public class Tip extends ProvidedObject {

    public static final int STREET_NAME_MAX_LENGTH = 64;
    public static final int CONTENT_MAX_LENGTH = 1024;

    @NotNull @NotBlank @Size(max = STREET_NAME_MAX_LENGTH)
    private String title;

    @NotNull @NotBlank @Size(max = CONTENT_MAX_LENGTH)
    private String content;

    @URL
    private String moreInfo;
}
