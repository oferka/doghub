package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.service.user.DogHubUserService;
import org.hk.doghub.model.DogHubFeedback;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EntityCreationService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Set;

import static org.hk.doghub.model.user.DogHubUser.USER_NAME_MAX_LENGTH;
import static org.hk.doghub.model.user.Role.USER;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCreationService implements EntityCreationService<DogHubUser, UserCreationParameters> {

    private final DogHubUserService userService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public @NotNull DogHubUser create(@NotNull UserCreationParameters creationParameters) {
        return create(creationParameters.getName(), creationParameters.getPassword());
    }

    @Override
    public boolean exists(@NotNull UserCreationParameters creationParameters) {
        return exists(creationParameters.getName());
    }

    private DogHubUser create(@NotNull @Size(max = USER_NAME_MAX_LENGTH) String username, @NotNull String password) {
        return userService.save(getUserEntity(username, password));
    }

    private @NotNull DogHubUser getUserEntity(@NotNull @Size(max = USER_NAME_MAX_LENGTH) String username, @NotNull String password) {
        DogHubUser result = new DogHubUser();
        result.setUsername(username);
        result.setEmail(username);
        result.setName(username);
        result.setHashedPassword(passwordEncoder.encode(password));
        result.setRoles(Set.of(USER));
        result.setCreationTime(ZonedDateTime.now());
        result.setFeedback(new DogHubFeedback());
        return result;
    }

    private boolean exists(@NotNull @Size(max = USER_NAME_MAX_LENGTH) String username) {
        return userService.existsByUsername(username);
    }
}
