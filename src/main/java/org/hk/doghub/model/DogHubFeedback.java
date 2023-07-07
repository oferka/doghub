package org.hk.doghub.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class DogHubFeedback {

    @PositiveOrZero
    private Long likes = 0L;

    @PositiveOrZero
    private Long comments = 0L;

    @PositiveOrZero
    private Long shares = 0L;
}
