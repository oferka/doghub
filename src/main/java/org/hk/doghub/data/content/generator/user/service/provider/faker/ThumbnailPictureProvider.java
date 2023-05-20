package org.hk.doghub.data.content.generator.user.service.provider.faker;

import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.RandomUtils;
import org.hibernate.validator.constraints.URL;
import org.hk.doghub.data.content.generator.user.model.User;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class ThumbnailPictureProvider {

    public @NotNull @URL String get(@NotNull User user) {
        String gender = (RandomUtils.nextBoolean())?"men":"women";
        String index = Integer.toString(RandomUtils.nextInt(1, 100));
        return format("https://randomuser.me/api/portraits/thumb/%s/%s.jpg", gender, index);
    }
}
