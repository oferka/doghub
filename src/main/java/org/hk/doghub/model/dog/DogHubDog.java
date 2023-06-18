package org.hk.doghub.model.dog;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.hk.doghub.model.*;
import org.hk.doghub.model.user.DogHubUser;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = { @UniqueConstraint(name = "Unique_name_and_created_by_id", columnNames = { "name", "created_by_id" }) })
public class DogHubDog extends NamedEntity implements HasThumbnailPicture, HasFeedback, HasCreatedBy {

    public static final int BREED_MAX_LENGTH = 64;

    public static final int SOUND_MAX_LENGTH = 64;

    public static final int AGE_MAX_LENGTH = 32;

    public static final int COAT_LENGTH_MAX_LENGTH = 32;

    public static final int SIZE_MAX_LENGTH = 32;

    public static final int GENDER_MAX_LENGTH = 32;

    @Size(max = BREED_MAX_LENGTH)
    private String breed;

    @Size(max = SOUND_MAX_LENGTH)
    private String sound;

    @Size(max = AGE_MAX_LENGTH)
    private String age;

    @Size(max = COAT_LENGTH_MAX_LENGTH)
    private String coatLength;

    @Size(max = SIZE_MAX_LENGTH)
    private String size;

    @Size(max = GENDER_MAX_LENGTH)
    private String gender;

    @Size(max = THUMBNAIL_PICTURE_MAX_LENGTH) @URL
    private String thumbnailPicture;

    @Embedded
    private DogHubFeedback feedback;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="created_by_id")
    private DogHubUser createdBy;
}
