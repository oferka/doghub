package org.hk.doghub.model;

import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

@FunctionalInterface
public interface HasThumbnailPicture {

    int THUMBNAIL_PICTURE_MAX_LENGTH = 1024;

    @Size(max = THUMBNAIL_PICTURE_MAX_LENGTH) @URL String getThumbnailPicture();
}
