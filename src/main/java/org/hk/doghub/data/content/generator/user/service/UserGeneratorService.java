package org.hk.doghub.data.content.generator.user.service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.content.generator.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static org.hk.doghub.data.content.generator.user.service.UserProvider.MAX_NUMBER_OF_USERS;
import static org.hk.doghub.data.content.generator.user.service.UserProvider.MIN_NUMBER_OF_USERS;

@Service
@RequiredArgsConstructor
@Validated
public class UserGeneratorService {

    private final UserProvider userProvider;

    public List<User> generate(@Min(MIN_NUMBER_OF_USERS) @Max(MAX_NUMBER_OF_USERS) int numberOfUsers) {
        return userProvider.generate(numberOfUsers);
    }

    public User generate() {
        return userProvider.generate();
    }
}
