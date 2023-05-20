package org.hk.doghub.data.content.provider.user;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.user.DogHubAddress;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

import static org.hk.doghub.model.user.Role.ADMIN;
import static org.hk.doghub.model.user.Role.USER;


@Service
@RequiredArgsConstructor
@Slf4j
public class AdminDogHubUserContentProvider {

    private final PasswordEncoder passwordEncoder;

    public @NotNull DogHubUser get() {
        DogHubUser adminUsaUser = new DogHubUser();
        adminUsaUser.setName("Ofer Karp");
        adminUsaUser.setUsername("ofer.karp@gmail.com");
        adminUsaUser.setEmail("ofer.karp@gmail.com");
        adminUsaUser.setTitle("Mr");
        adminUsaUser.setThumbnailPicture("https://en.gravatar.com/userimage/33131799/3024d9952717995b6facc57f7bd50d2e.png");
        adminUsaUser.setDateOfBirth(ZonedDateTime.of(LocalDate.of(1976, 4, 15), LocalTime.of(2,  44), ZoneId.of("GMT+02:00")));
        adminUsaUser.setDateOfRegistration(ZonedDateTime.of(LocalDate.of(2010, 3, 19), LocalTime.of(6,  35), ZoneId.of("GMT+02:00")));
        adminUsaUser.setCompany("Karpisimo.com");
        adminUsaUser.setAddress(getAddress());
        adminUsaUser.setMobileNumber("+972545597059");
        adminUsaUser.setHashedPassword(passwordEncoder.encode("password"));
        adminUsaUser.setLikes(12L);
        adminUsaUser.setComments(11L);
        adminUsaUser.setShares(10L);
        adminUsaUser.setRoles(Set.of(USER, ADMIN));
        return adminUsaUser;
    }

    private @NotNull DogHubAddress getAddress() {
        DogHubAddress address = new DogHubAddress();
        address.setNumber(22);
        address.setStreetName("Holy Tree");
        address.setCity("Shadmot Dvora");
        address.setState("Lower Galilee");
        address.setCountry("Israel");
        address.setPostcode("1524000");
        return address;
    }
}
