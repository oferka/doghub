package org.hk.doghub.data.content.generator.tip.domcop.csv;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TipLine {

    @NotNull
    @Size(min = 1, max = 64)
    @NotBlank
    @Getter
    private String id;

    @NotNull
    @Size(min = 1, max = 256)
    @NotBlank
    @Getter
    private String address;

    @NotNull
    @Size(min = 1, max = 64)
    @NotBlank
    @Getter
    private String popularity;
}
