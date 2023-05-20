package org.hk.doghub.security;

import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.service.user.DogHubUserService;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final DogHubUserService dogHubUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<DogHubUser> userOptional = dogHubUserService.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("No user present with username: " + username);
        }
        else {
            DogHubUser user = userOptional.get();
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getHashedPassword(), getAuthorities(user));
        }
    }

    private static List<GrantedAuthority> getAuthorities(DogHubUser user) {
        return user.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList());
    }
}
