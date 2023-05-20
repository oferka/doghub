package org.hk.doghub.data.content.generator.user.service.provider.faker;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.content.generator.user.model.Address;
import org.hk.doghub.data.content.generator.user.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressProvider {

    private final HouseNumberProvider houseNumberProvider;

    private final StreetNameProvider streetNameProvider;

    private final CityProvider cityProvider;

    private final StateProvider stateProvider;

    private final CountryProvider countryProvider;

    private final PostcodeProvider postcodeProvider;

    public @NotNull @Size(min = 2, max = 64) @NotBlank Address get(@NotNull User user) {
        Address address = new Address();
        address.setNumber(houseNumberProvider.get(address));
        address.setStreetName(streetNameProvider.get(address));
        address.setCity(cityProvider.get(address));
        address.setState(stateProvider.get(address));
        address.setCountry(countryProvider.get(address));
        address.setPostcode(postcodeProvider.get(address));
        return address;
    }
}
