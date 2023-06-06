package org.hk.doghub.model.tip;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.model.user.DogHubUser;

import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = { @UniqueConstraint(name = "Unique_title_and_created_by_id", columnNames = { "title", "created_by_id" }) })
public class DogHubTip extends NamedEntity {

    public static final int TITLE_MAX_LENGTH = 64;

    public static final int CONTENT_MAX_LENGTH = 1024;

    public static final int MORE_INFO_MAX_LENGTH = 1024;

    public static final int THUMBNAIL_PICTURE_MAX_LENGTH = 1024;

    @NotNull
    @Size(max = TITLE_MAX_LENGTH)
    @NotBlank
    private String title;

    @Size(max = CONTENT_MAX_LENGTH)
    private String content;

    @Size(max = MORE_INFO_MAX_LENGTH)
    private String moreInfo;

    @Size(max = THUMBNAIL_PICTURE_MAX_LENGTH)
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
    @JoinColumn(name="created_by_id")
    private DogHubUser createdBy;
}
