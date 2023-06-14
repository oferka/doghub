package org.hk.doghub.data.content.generator.user.service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.content.generator.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static org.hk.doghub.data.content.generator.EntityProvider.MAX_NUMBER_OF_ITEMS;
import static org.hk.doghub.data.content.generator.EntityProvider.MIN_NUMBER_OF_ITEMS;

@Service
@RequiredArgsConstructor
@Validated
public class UserGeneratorService {

    private final UserProvider userProvider;

    public List<User> generate(@Min(MIN_NUMBER_OF_ITEMS) @Max(MAX_NUMBER_OF_ITEMS) int numberOfUsers) {
        return userProvider.get(numberOfUsers);
    }

    public User generate() {
        return userProvider.get();
    }
}
