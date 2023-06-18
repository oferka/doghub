package org.hk.doghub.data.content.generator.dog.faker;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.hk.doghub.data.content.generator.dog.Dog;
import org.springframework.stereotype.Service;

import java.net.URI;

import static org.hk.doghub.data.content.generator.dog.Dog.BREED_MAX_LENGTH;

@Service
@Slf4j
public class DogBreedProvider {

    public @NotNull @NotBlank @Size(max = BREED_MAX_LENGTH) String get(@NotNull Dog dog) {
        String result = new Faker().dog().breed();
        try {
            String thumbnailPicturePath = new URI(dog.getThumbnailPicture()).getPath();
            String thumbnailPicturePathWithoutPrefix = thumbnailPicturePath.replace("/breeds/", "");
            result = thumbnailPicturePathWithoutPrefix.substring(0, thumbnailPicturePathWithoutPrefix.indexOf("/"));
        }
        catch (Exception e) {
            log.error("Failed to get breed from thumbnail picture", e);
        }
        return result;
    }
}
