package org.hk.doghub.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
public class DogHubTip extends NamedEntity {

    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    private String title;

    @NotNull
    @Size(min = 2, max = 1024)
    @NotBlank
    private String content;

//    @URL
    private String moreInfo;

    @URL
    private String thumbnailPicture;

    @PositiveOrZero
    private Long likes = 0L;

    @PositiveOrZero
    private Long comments = 0L;

    @PositiveOrZero
    private Long shares = 0L;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @Past
    private ZonedDateTime creationTime;

    @ManyToOne(fetch = FetchType.EAGER)
    private DogHubUser createdBy;
}
