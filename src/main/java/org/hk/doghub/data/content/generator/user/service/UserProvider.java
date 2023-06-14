package org.hk.doghub.data.content.generator.user.service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hk.doghub.data.content.generator.user.model.User;

import java.util.List;

public interface UserProvider {

    int MIN_NUMBER_OF_USERS = 1;

    int MAX_NUMBER_OF_USERS = 999;

    List<User> get(@Min(MIN_NUMBER_OF_USERS) @Max(MAX_NUMBER_OF_USERS) int numberOfItems);

    User get();
}
