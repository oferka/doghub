package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.service.user.DogHubUserService;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Set;

import static org.hk.doghub.model.user.DogHubUser.USER_NAME_MAX_LENGTH;
import static org.hk.doghub.model.user.Role.USER;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCreationService {

    private final DogHubUserService userService;

    private final PasswordEncoder passwordEncoder;

    public DogHubUser create(@NotNull @Size(max = USER_NAME_MAX_LENGTH) String username,
                             @NotNull String password) {
        return userService.save(getUserEntity(username, password));
    }

    private @NotNull DogHubUser getUserEntity(@NotNull @Size(max = USER_NAME_MAX_LENGTH) String username,
                                              @NotNull String password) {
        DogHubUser result = new DogHubUser();
        result.setUsername(username);
        result.setEmail(username);
        result.setName(username);
        result.setHashedPassword(passwordEncoder.encode(password));
        result.setRoles(Set.of(USER));
        result.setDateOfRegistration(ZonedDateTime.now());
        return result;
    }

    public boolean exists(@NotNull @Size(max = USER_NAME_MAX_LENGTH) String username) {
        return userService.existsByUsername(username);
    }
}
