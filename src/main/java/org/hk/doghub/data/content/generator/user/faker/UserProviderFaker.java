package org.hk.doghub.data.content.generator.user.faker;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.user.User;
import org.hk.doghub.data.content.generator.user.UserProvider;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
@RequiredArgsConstructor
@Validated
@Primary
public class UserProviderFaker implements UserProvider {

    private final FirstNameProvider firstNameProvider;

    private final LastNameProvider lastNameProvider;

    private final EmailProvider emailProvider;

    private final TitleProvider titleProvider;

    private final CompanyProvider companyProvider;

    private final MobileNumberProvider mobileNumberProvider;

    private final AddressProvider addressProvider;

    private final PasswordProvider passwordProvider;

    private final ThumbnailPictureProvider thumbnailPictureProvider;

    private final DateOfBirthProvider dateOfBirthProvider;

    @Override
    public @NotNull List<User> get(@Min(MIN_NUMBER_OF_ITEMS) @Max(MAX_NUMBER_OF_ITEMS) int numberOfItems) {
        return IntStream.range(0, numberOfItems).mapToObj(x -> get()).collect(Collectors.toList());
    }

    @Override
    public @NotNull User get() {
        User result = new User();
        result.setFirstName(firstNameProvider.get(result));
        result.setLastName(lastNameProvider.get(result));
        result.setEmail(emailProvider.get(result));
        result.setTitle(titleProvider.get(result));
        result.setCompany(companyProvider.get(result));
        result.setMobileNumber(mobileNumberProvider.get(result));
        result.setAddress(addressProvider.get(result));
        result.setPassword(passwordProvider.get(result));
        result.setThumbnailPicture(thumbnailPictureProvider.get(result));
        result.setDateOfBirth(dateOfBirthProvider.get(result));
        return result;
    }
}
