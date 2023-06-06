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

    public DogHubUser create(@NotNull @Size(max = USER_NAME_MAX_LENGTH) String username,
                             @NotNull String password) {
        return userService.save(getUserEntity(username, password));
    }

    public DogHubUser save(@NotNull Long id,
                           @NotNull @Size(max = USER_NAME_MAX_LENGTH) String username,
                           @Size(max = TITLE_MAX_LENGTH) String title,
                           @Size(max = NAME_MAX_LENGTH) String name,
                           @Size(max = MOBILE_NUMBER_MAX_LENGTH) String mobileNumber,
                           @Email @Size(max = EMAIL_MAX_LENGTH)String email,
                           @URL @Size(max = THUMBNAIL_PICTURE_MAX_LENGTH) String thumbnailPicture,
                           @Size(max = COMPANY_MAX_LENGTH) String company,
                           @Past ZonedDateTime dateOfBirth,
                           @NotNull @Past ZonedDateTime dateOfRegistration,
                           @Size(max = COUNTRY_MAX_LENGTH) String country,
                           @Size(max = STATE_MAX_LENGTH) String state,
                           @Size(max = CITY_MAX_LENGTH) String city,
                           @Size(max = STREET_NAME_MAX_LENGTH) String streetName,
                           @Positive Integer number,
                           @Size(max = POSTCODE_MAX_LENGTH) String postcode) {
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
