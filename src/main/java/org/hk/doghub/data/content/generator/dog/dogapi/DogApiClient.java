package org.hk.doghub.data.content.generator.dog.dogapi;

import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.hk.doghub.data.content.generator.dog.dogapi.DogApiUriComponents.LIST_ALL_BREEDS_URL;
import static org.hk.doghub.data.content.generator.dog.dogapi.DogApiUriComponents.RANDOM_IMAGE_FROM_ALL_DOGS_COLLECTION_URL;

@Service
@RequiredArgsConstructor
public class DogApiClient {

    public DogApiRandomImageResponse getRandomImageFromAllDogsCollection() throws URISyntaxException, IOException {
        return new JsonMapper().readValue(new URI(RANDOM_IMAGE_FROM_ALL_DOGS_COLLECTION_URL).toURL(), DogApiRandomImageResponse.class);
    }

    public DogApiListAllBreedsResponse getAllBreeds() throws URISyntaxException, IOException {
        return new JsonMapper().readValue(new URI(LIST_ALL_BREEDS_URL).toURL(), DogApiListAllBreedsResponse.class);
    }
}
