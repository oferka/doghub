package org.hk.doghub.ui.views.site.signup;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.service.user.DogHubUserService;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Set;

import static org.hk.doghub.model.user.Role.USER;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignupService {

    private final DogHubUserService userService;

    private final PasswordEncoder passwordEncoder;

    public DogHubUser signupWithEmailAndPassword(@NotNull @Email String email, @NotNull String password) {
        return userService.save(getUserEntity(email, password));
    }

    private @NotNull DogHubUser getUserEntity(@NotNull @Email String email, @NotNull String password) {
        DogHubUser result = new DogHubUser();
        result.setUsername(email);
        result.setEmail(email);
        result.setName(email);
        result.setHashedPassword(passwordEncoder.encode(password));
        result.setRoles(Set.of(USER));
        result.setDateOfRegistration(ZonedDateTime.now());
        return result;
    }

    public boolean exists(@NotNull @Email String email) {
        return userService.existsByUsername(email);
    }
}
