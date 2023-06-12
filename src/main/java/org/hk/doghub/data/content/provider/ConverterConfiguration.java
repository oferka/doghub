package org.hk.doghub.data.content.provider;

import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.content.generator.user.model.User;
import org.hk.doghub.model.user.DogHubUser;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ConverterConfiguration {

    @Bean
    public ModelMapper userModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(User.class, DogHubUser.class).addMappings(mapper -> mapper.map(User::getEmail, DogHubUser::setUsername));
        return modelMapper;
    }
}
