package org.hk.doghub.data.content.generator.dog.dogapi;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class DogApiClientTest {

    @Autowired
    private DogApiClient dogApiClient;

    @RepeatedTest(3)
    public void shouldGetRandomImageFromAllDogsCollection() throws URISyntaxException, IOException {
        DogApiRandomImageResponse response = dogApiClient.getRandomImageFromAllDogsCollection();
        assertNotNull(response);
        log.info(response.getMessage());
    }

    @RepeatedTest(3)
    public void shouldGetAllBreeds() throws URISyntaxException, IOException {
        DogApiListAllBreedsResponse response = dogApiClient.getAllBreeds();
        assertNotNull(response);
        log.info(response.getStatus());
    }
}