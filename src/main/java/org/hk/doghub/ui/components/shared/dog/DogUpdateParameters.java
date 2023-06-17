package org.hk.doghub.ui.components.shared.dog;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.hk.doghub.ui.components.shared.EntityUpdateParameters;

import static org.hk.doghub.model.HasThumbnailPicture.THUMBNAIL_PICTURE_MAX_LENGTH;
import static org.hk.doghub.model.dog.DogHubDog.*;

@Getter
@Setter
public class DogUpdateParameters extends EntityUpdateParameters {

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
}
