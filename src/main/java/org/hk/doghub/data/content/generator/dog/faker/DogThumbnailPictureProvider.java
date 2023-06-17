package org.hk.doghub.data.content.generator.dog.faker;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.URL;
import org.hk.doghub.data.content.generator.dog.Dog;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogThumbnailPictureProvider {

    private final DogApiClient dogApiClient;

    public @NotNull @URL String get(@NotNull Dog dog) {
        String result = "https://images.dog.ceo/breeds/collie-border/n02106166_731.jpg";
        try {
            DogApiRandomImageResponse dogApiRandomImageResponse = dogApiClient.getRandomImageFromAllDogsCollection();
            if(dogApiRandomImageResponse.getStatus().equals("success")) {
                result = dogApiRandomImageResponse.getMessage();
            }
        }
        catch (URISyntaxException | IOException e) {
            log.error("Failed to get thumbnail for dog", e);
        }
        return result;
    }
}
