package org.hk.doghub.data.content.provider.user;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.hk.doghub.data.content.generator.user.User;
import org.hk.doghub.model.DogHubFeedback;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.model.user.Role;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserConverter {

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper userModelMapper;

    public DogHubUser convert(@NotNull User user) {
        DogHubUser dogHubUser = userModelMapper.map(user, DogHubUser.class);
        dogHubUser.setCreationTime(ZonedDateTime.now().minusDays(RandomUtils.nextLong(1, 1000)));
        dogHubUser.setHashedPassword(passwordEncoder.encode(user.getPassword()));
        dogHubUser.setFeedback(getFeedback());
        dogHubUser.setRoles(getUserRoles());
        log.info(format("User Name: %s, password: %s, roles: %s", dogHubUser.getUsername(), user.getPassword(), dogHubUser.getRoles()));
        return dogHubUser;
    }

    public List<DogHubUser> convert(List<User> users) {
        List<DogHubUser> result =  new ArrayList<>();
        for(User user : users) {
            result.add(convert(user));
        }
        return result;
    }

    private @NotNull DogHubFeedback getFeedback() {
        DogHubFeedback result = new DogHubFeedback();
        result.setLikes(getLikes());
        result.setShares(getShares());
        result.setComments(getComments());
        return result;
    }

    private long getLikes() {
        return RandomUtils.nextLong(0, 10000);
    }

    private long getShares() {
        return RandomUtils.nextLong(0, 10000);
    }

    private long getComments() {
        return RandomUtils.nextLong(0, 10000);
    }

    private Set<Role> getUserRoles() {
        Set<Role> result = new HashSet<>();
        Role[] allRoles = Role.values();
        for(Role role : allRoles) {
            if(RandomUtils.nextBoolean()) {
                result.add(role);
            }
        }
        return result;
    }
}
