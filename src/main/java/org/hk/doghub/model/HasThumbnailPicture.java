package org.hk.doghub.model;

import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public interface HasThumbnailPicture {

    public static final int THUMBNAIL_PICTURE_MAX_LENGTH = 1024;

    @Size(max = THUMBNAIL_PICTURE_MAX_LENGTH) @URL String getThumbnailPicture();
}
