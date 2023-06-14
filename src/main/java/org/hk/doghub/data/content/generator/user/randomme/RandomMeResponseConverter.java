package org.hk.doghub.data.content.generator.user.randomme;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.user.Address;
import org.hk.doghub.data.content.generator.user.User;
import org.hk.doghub.data.content.generator.user.randomme.response.Location;
import org.hk.doghub.data.content.generator.user.randomme.response.RandomMeResponse;
import org.hk.doghub.data.content.generator.user.randomme.response.Result;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RandomMeResponseConverter {

    private final CompanyProvider companyProvider;

    public List<User> convertToUsers(@NotNull RandomMeResponse randomMeResponse) {
        return convertToUsers(randomMeResponse.getResults());
    }

    public User convertToUser(@NotNull RandomMeResponse randomMeResponse) {
        return convertToUser(randomMeResponse.getResults().get(0));
    }

    private List<User> convertToUsers(@NotNull List<Result> results) {
        List<User> users = new ArrayList<>();
        for(Result result : results) {
            users.add(convertToUser(result));
        }
        return users;
    }

    private User convertToUser(@NotNull Result result) {
        User user = new User();
        user.setFirstName(result.getName().getFirst());
        user.setLastName(result.getName().getLast());
        user.setEmail(result.getEmail());
        user.setTitle(result.getName().getTitle());
        user.setCompany(companyProvider.get(result));
        user.setAddress(convertToAddress(result.getLocation()));
        user.setPassword(result.getLogin().getPassword());
        user.setDateOfBirth(ZonedDateTime.parse(result.getDob().getDate()));
        user.setThumbnailPicture(result.getPicture().getThumbnail());
        user.setMobileNumber(result.getPhone());
        return user;
    }

    private Address convertToAddress(@NotNull Location location) {
        Address address = new Address();
        address.setNumber(location.getStreet().getNumber());
        address.setStreetName(location.getStreet().getName());
        address.setCity(location.getCity());
        address.setState(location.getState());
        address.setCountry(location.getCountry());
        address.setPostcode(location.getPostcode());
        return address;
    }
}
