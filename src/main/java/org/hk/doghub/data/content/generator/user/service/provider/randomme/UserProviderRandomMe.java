package org.hk.doghub.data.content.generator.user.service.provider.randomme;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.user.model.User;
import org.hk.doghub.data.content.generator.user.service.UserProvider;
import org.hk.doghub.data.content.generator.user.service.provider.randomme.response.RandomMeResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
@Slf4j
public class UserProviderRandomMe implements UserProvider {

    private final RandomMeClient randomMeClient;

    private final RandomMeResponseConverter randomMeResponseConverter;

    @Override
    public List<User> generate(@Min(MIN_NUMBER_OF_USERS) @Max(MAX_NUMBER_OF_USERS) int numberOfItems) {
        RandomMeResponse response = randomMeClient.get(numberOfItems);
        return randomMeResponseConverter.convertToUsers(response);
    }

    @Override
    public User generate() {
        RandomMeResponse response = randomMeClient.get();
        return randomMeResponseConverter.convertToUser(response);
    }
}
