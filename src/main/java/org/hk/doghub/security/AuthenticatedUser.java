package org.hk.doghub.security;

import com.vaadin.flow.spring.security.AuthenticationContext;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.service.user.DogHubUserService;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.hk.doghub.model.user.Role.ADMIN;
import static org.hk.doghub.model.user.Role.USER;

@Component
@RequiredArgsConstructor
public class AuthenticatedUser {

    private final DogHubUserService dogHubUserService;
    private final AuthenticationContext authenticationContext;

    public Optional<DogHubUser> get() {
        return authenticationContext.getAuthenticatedUser(UserDetails.class).map(userDetails -> dogHubUserService.findByUsername(userDetails.getUsername()).get());
    }

    public void logout() {
        authenticationContext.logout();
    }

    public boolean hasAdminRole() {
        boolean result = false;
        Optional<DogHubUser> optionalUser = get();
        if(optionalUser.isPresent()) {
            result = optionalUser.get().getRoles().contains(ADMIN);
        }
        return result;
    }

    public boolean hasUserRole() {
        boolean result = false;
        Optional<DogHubUser> optionalUser = get();
        if(optionalUser.isPresent()) {
            result = optionalUser.get().getRoles().contains(USER);
        }
        return result;
    }
}
