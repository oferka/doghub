package org.hk.doghub.data.content.generator.user.randomme;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.user.User;
import org.hk.doghub.data.content.generator.user.UserProvider;
import org.hk.doghub.data.content.generator.user.randomme.response.RandomMeResponse;
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
    public @NotNull List<User> get(@Min(MIN_NUMBER_OF_ITEMS) @Max(MAX_NUMBER_OF_ITEMS) int numberOfItems) {
        RandomMeResponse response = randomMeClient.get(numberOfItems);
        return randomMeResponseConverter.convertToUsers(response);
    }

    @Override
    public @NotNull User get() {
        return get(20).get(0);
    }
}
