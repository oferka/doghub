package org.hk.doghub.data.content.generator.user.service.provider.randomme;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.user.service.provider.randomme.response.RandomMeResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.hk.doghub.data.content.generator.user.service.provider.randomme.RandomMeUriComponents.API_ROOT_URL;

@Service
@RequiredArgsConstructor
@Slf4j
public class RandomMeClient {

    private final RestTemplate restTemplate;

    public RandomMeResponse get() {
        return restTemplate.getForObject(API_ROOT_URL, RandomMeResponse.class);
    }

    public RandomMeResponse get(int numberOfUsers) {
        return restTemplate.getForObject(API_ROOT_URL + "?results=" + numberOfUsers, RandomMeResponse.class);
    }
}
