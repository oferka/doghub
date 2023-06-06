package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.URL;
import org.hk.doghub.data.service.user.DogHubUserService;
import org.hk.doghub.model.user.DogHubAddress;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Set;

import static java.lang.String.format;
import static org.hk.doghub.model.NamedEntity.NAME_MAX_LENGTH;
import static org.hk.doghub.model.NamedEntity.NAME_MIN_LENGTH;
import static org.hk.doghub.model.user.DogHubUser.USER_NAME_MAX_LENGTH;
import static org.hk.doghub.model.user.DogHubUser.USER_NAME_MIN_LENGTH;
import static org.hk.doghub.model.user.Role.USER;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCreationService {

    private final DogHubUserService userService;

    private final PasswordEncoder passwordEncoder;

    public DogHubUser create(@NotNull @Email String email, @NotNull String password) {
        return userService.save(getUserEntity(email, password));
    }

    public DogHubUser save(
            @NotNull Long id,
            @NotNull @Size(min = USER_NAME_MIN_LENGTH, max = USER_NAME_MAX_LENGTH) @NotBlank String username,
            @Size(min = 2, max = 64) String title,
            @NotNull @Size(min = NAME_MIN_LENGTH, max = NAME_MAX_LENGTH) @NotBlank String name,
            @Size(min = 2, max = 64) String mobileNumber,
            @Email String email,
            @URL String thumbnailPicture,
            @Size(min = 2, max = 64) String company,
            @Past ZonedDateTime dateOfBirth,
            @Past ZonedDateTime dateOfRegistration,
            @NotNull @Size(min = 2, max = 64) @NotBlank String country,
            @NotNull @Size(min = 2, max = 64) @NotBlank String state,
            @NotNull @Size(min = 2, max = 64) @NotBlank String city,
            @NotNull @Size(min = 2, max = 64) @NotBlank String streetName,
            @Positive Integer number,
            @NotNull @Size(min = 2, max = 64) @NotBlank String postcode) {
        Optional<DogHubUser> userOptional = userService.findById(id);
        if(userOptional.isPresent()) {
            DogHubUser user = userOptional.get();
            user.setName(name);
            user.setUsername(username);
            user.setEmail(email);
            user.setTitle(title);
            user.setThumbnailPicture(thumbnailPicture);
            user.setDateOfBirth(dateOfBirth);
            user.setDateOfRegistration(dateOfRegistration);
            user.setCompany(company);
            user.setMobileNumber(mobileNumber);
            DogHubAddress address = user.getAddress();
            if(address == null) {
                address = new DogHubAddress();
                user.setAddress(address);
            }
            address.setNumber(number);
            address.setStreetName(streetName);
            address.setCity(city);
            address.setState(state);
            address.setCountry(country);
            address.setPostcode(postcode);
            return userService.save(user);
        }
        throw new IllegalArgumentException(format("Failed to save user with ID: %s'", id));
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
