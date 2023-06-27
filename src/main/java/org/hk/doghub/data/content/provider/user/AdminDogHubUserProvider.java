package org.hk.doghub.data.content.provider.user;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.DogHubFeedback;
import org.hk.doghub.model.user.DogHubAddress;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

import static org.hk.doghub.model.user.Role.ADMIN;
import static org.hk.doghub.model.user.Role.USER;


@Service
@RequiredArgsConstructor
@Slf4j
public class AdminDogHubUserProvider {

    private final AdminDogHubUserProviderConfiguration configuration;

    private final PasswordEncoder passwordEncoder;

    public @NotNull DogHubUser get() {
        DogHubUser adminUsaUser = new DogHubUser();
        adminUsaUser.setName(configuration.getName());
        adminUsaUser.setUsername(configuration.getUsername());
        adminUsaUser.setEmail(configuration.getEmail());
        adminUsaUser.setTitle(configuration.getTitle());
        adminUsaUser.setThumbnailPicture(configuration.getThumbnailPicture());
        adminUsaUser.setDateOfBirth(configuration.getDateOfBirth());
        adminUsaUser.setCreationTime(configuration.getCreationTime());
        adminUsaUser.setCompany(configuration.getCompany());
        adminUsaUser.setAddress(getAddress());
        adminUsaUser.setMobileNumber(configuration.getMobileNumber());
        adminUsaUser.setHashedPassword(passwordEncoder.encode(configuration.getPassword()));
        adminUsaUser.setFeedback(getFeedback());
        adminUsaUser.setRoles(Set.of(USER, ADMIN));
        return adminUsaUser;
    }

    private @NotNull DogHubAddress getAddress() {
        DogHubAddress address = new DogHubAddress();
        address.setNumber(configuration.getNumber());
        address.setStreetName(configuration.getStreetName());
        address.setCity(configuration.getCity());
        address.setState(configuration.getState());
        address.setCountry(configuration.getCountry());
        address.setPostcode(configuration.getPostcode());
        return address;
    }

    private @NotNull DogHubFeedback getFeedback() {
        DogHubFeedback result = new DogHubFeedback();
        result.setLikes(configuration.getLikes());
        result.setComments(configuration.getComments());
        result.setShares(configuration.getShares());
        return result;
    }
}
