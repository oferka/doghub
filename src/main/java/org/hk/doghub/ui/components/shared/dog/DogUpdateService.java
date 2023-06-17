package org.hk.doghub.ui.components.shared.dog;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.URL;
import org.hk.doghub.data.service.dog.DogHubDogService;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.ui.components.shared.EntityUpdateService;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.String.format;
import static org.hk.doghub.model.HasThumbnailPicture.THUMBNAIL_PICTURE_MAX_LENGTH;
import static org.hk.doghub.model.NamedEntity.NAME_MAX_LENGTH;
import static org.hk.doghub.model.dog.DogHubDog.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class DogUpdateService implements EntityUpdateService<DogHubDog, DogUpdateParameters> {

    private final DogHubDogService dogService;

    @Override
    public @NotNull DogHubDog update(@NotNull DogUpdateParameters updateParameters) {
        return update(
                updateParameters.getId(),
                updateParameters.getName(),
                updateParameters.getBreed(),
                updateParameters.getSound(),
                updateParameters.getAge(),
                updateParameters.getCoatLength(),
                updateParameters.getSize(),
                updateParameters.getGender(),
                updateParameters.getThumbnailPicture()
        );
    }

    private @NotNull DogHubDog update(@NotNull Long id,
                                      @NotNull @Size(max = NAME_MAX_LENGTH) String name,
                                      @NotNull @Size(max = BREED_MAX_LENGTH) String breed,
                                      @Size(max = SOUND_MAX_LENGTH) String sound,
                                      @Size(max = AGE_MAX_LENGTH) String age,
                                      @Size(max = COAT_LENGTH_MAX_LENGTH) String coatLength,
                                      @Size(max = SIZE_MAX_LENGTH) String size,
                                      @Size(max = GENDER_MAX_LENGTH) String gender,
                                      @Size(max = THUMBNAIL_PICTURE_MAX_LENGTH) @URL String thumbnailPicture) {
        Optional<DogHubDog> dogOptional = dogService.findById(id);
        if(dogOptional.isPresent()) {
            DogHubDog dog = dogOptional.get();
            dog.setName(name);
            dog.setBreed(breed);
            dog.setSound(sound);
            dog.setAge(age);
            dog.setCoatLength(coatLength);
            dog.setSize(size);
            dog.setGender(gender);
            dog.setThumbnailPicture(thumbnailPicture);
            return dogService.save(dog);
        }
        throw new IllegalArgumentException(format("Failed to save dog with ID: %s'", id));
    }
}
