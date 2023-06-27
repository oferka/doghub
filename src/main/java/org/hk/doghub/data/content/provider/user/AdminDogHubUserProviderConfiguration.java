package org.hk.doghub.data.content.provider.user;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.ZonedDateTime;

@Configuration
@PropertySource("classpath:admin-user.properties")
@ConfigurationProperties(prefix = "admin.user")
@Data
public class AdminDogHubUserProviderConfiguration {

    private String name;
    private String username;
    private String email;
    private String title;
    private String thumbnailPicture;
    private ZonedDateTime dateOfBirth;
    private ZonedDateTime creationTime;
    private String company;
    private String mobileNumber;
    private String password;
    private int number;
    private String streetName;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private long likes;
    private long shares;
    private long comments;
}
