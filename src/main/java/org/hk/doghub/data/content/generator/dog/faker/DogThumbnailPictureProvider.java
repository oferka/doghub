package org.hk.doghub.data.content.generator.dog.faker;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;
import org.hk.doghub.data.content.generator.dog.Dog;
import org.springframework.stereotype.Service;

@Service
public class DogThumbnailPictureProvider {

    public @NotNull @URL String get(@NotNull Dog dog) {
        return "https://images.dog.ceo/breeds/collie-border/n02106166_731.jpg";
    }
}
