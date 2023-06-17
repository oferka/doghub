package org.hk.doghub.data.content.generator.user.randomme;

import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.content.generator.user.randomme.response.RandomMeResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.hk.doghub.data.content.generator.user.randomme.RandomMeUriComponents.API_ROOT_URL;

@Service
@RequiredArgsConstructor
public class RandomMeClient {

    private final RestTemplate restTemplate;

    public RandomMeResponse get(int numberOfUsers) {
        return restTemplate.getForObject(API_ROOT_URL + "?results=" + numberOfUsers, RandomMeResponse.class);
    }
}
