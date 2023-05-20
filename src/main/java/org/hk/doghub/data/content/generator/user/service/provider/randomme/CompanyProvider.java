package org.hk.doghub.data.content.generator.user.service.provider.randomme;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hk.doghub.data.content.generator.user.service.provider.randomme.response.Result;

public interface CompanyProvider {

    @NotNull @NotBlank @Size(min = 2, max = 64) String get(Result result);
}
