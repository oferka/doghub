package org.hk.doghub.data.content.provider;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.hk.doghub.data.content.generator.user.model.User;
import org.hk.doghub.model.DogHubUser;
import org.hk.doghub.model.Role;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        dogHubUser.setHashedPassword(passwordEncoder.encode(user.getPassword()));
        dogHubUser.setLikes(getLikes(user));
        dogHubUser.setShares(getShares(user));
        dogHubUser.setComments(getComments(user));
        dogHubUser.setRoles(getUserRoles(user));
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

    private long getLikes(@NotNull User user) {
        return RandomUtils.nextLong(0, 10000);
    }

    private long getShares(@NotNull User user) {
        return RandomUtils.nextLong(0, 10000);
    }

    private long getComments(@NotNull User user) {
        return RandomUtils.nextLong(0, 10000);
    }

    private Set<Role> getUserRoles(@NotNull User user) {
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
