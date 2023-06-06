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

    public static final int NAME_MAX_LENGTH = 128;

    @NotNull
    @Size(max = NAME_MAX_LENGTH)
    @NotBlank
    private String name;
}
