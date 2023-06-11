package org.hk.doghub.model.tip;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.hk.doghub.model.DogHubFeedback;
import org.hk.doghub.model.HasThumbnailPicture;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.model.user.DogHubUser;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = { @UniqueConstraint(name = "Unique_title_and_created_by_id", columnNames = { "title", "created_by_id" }) })
public class DogHubTip extends NamedEntity implements HasThumbnailPicture {

    public static final int TITLE_MAX_LENGTH = 64;

    public static final int CONTENT_MAX_LENGTH = 1024;

    public static final int MORE_INFO_MAX_LENGTH = 1024;

    @NotNull @Size(max = TITLE_MAX_LENGTH)
    private String title;

    @Size(max = CONTENT_MAX_LENGTH)
    private String content;

    @Size(max = MORE_INFO_MAX_LENGTH)
    private String moreInfo;

    @Size(max = THUMBNAIL_PICTURE_MAX_LENGTH) @URL
    private String thumbnailPicture;

    @Embedded
    private DogHubFeedback feedback;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="created_by_id")
    private DogHubUser createdBy;
}
