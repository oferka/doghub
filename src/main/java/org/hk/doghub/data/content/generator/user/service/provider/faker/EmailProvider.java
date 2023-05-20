package org.hk.doghub.data.content.generator.user.service.provider.faker;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import net.datafaker.Faker;
import org.hk.doghub.data.content.generator.user.model.User;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class EmailProvider {

    public @Email String get(@NotNull User user) {
        String firstName = user.getFirstName().toLowerCase();
        String lastName = user.getLastName().toLowerCase();
        String domain = new Faker().internet().domainWord();
        String suffix = new Faker().internet().domainSuffix();
        return format("%s.%s@%s.%s", firstName, lastName, domain, suffix);
    }
}
