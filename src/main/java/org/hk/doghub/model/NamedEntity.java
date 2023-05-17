package org.hk.doghub.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class NamedEntity extends AbstractEntity {

    @NotNull
    @Size(min = 2, max = 128)
    @NotBlank
    private String name;
}
