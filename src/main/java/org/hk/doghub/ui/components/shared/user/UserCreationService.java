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

import javax.annotation.Nullable;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Set;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.NamedEntity.NAME_MAX_LENGTH;
import static org.hk.doghub.model.user.DogHubAddress.*;
import static org.hk.doghub.model.user.DogHubUser.*;
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
            @NotNull @Size(max = USER_NAME_MAX_LENGTH) @NotBlank String username,
            @Nullable @Size(max = TITLE_MAX_LENGTH) String title,
            @Nullable @Size(max = NAME_MAX_LENGTH) @NotBlank String name,
            @Nullable @Size(max = MOBILE_NUMBER_MAX_LENGTH) String mobileNumber,
            @Nullable @Email String email,
            @Nullable @URL @Size(max = THUMBNAIL_PICTURE_MAX_LENGTH) String thumbnailPicture,
            @Nullable @Size(max = COMPANY_MAX_LENGTH) String company,
            @Nullable @Past ZonedDateTime dateOfBirth,
            @NotNull @Past ZonedDateTime dateOfRegistration,
            @Nullable @Size(max = COUNTRY_MAX_LENGTH) @NotBlank String country,
            @Nullable @Size(max = STATE_MAX_LENGTH) @NotBlank String state,
            @Nullable @Size(max = CITY_MAX_LENGTH) @NotBlank String city,
            @Nullable @Size(max = STREET_NAME_MAX_LENGTH) @NotBlank String streetName,
            @Nullable @Positive Integer number,
            @Nullable @Size(max = POSTCODE_MAX_LENGTH) @NotBlank String postcode) {
        Optional<DogHubUser> userOptional = userService.findById(id);
        if(userOptional.isPresent()) {
            DogHubUser user = userOptional.get();
            user.setName((name != null) ? name : EMPTY);
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
            address.setStreetName((streetName != null) ? streetName : EMPTY);
            address.setCity((city != null) ? city : EMPTY);
            address.setState((state != null) ? state : EMPTY);
            address.setCountry((country != null) ? country : EMPTY);
            address.setPostcode((postcode != null) ? postcode : EMPTY);
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
