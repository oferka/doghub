package org.hk.doghub.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.model.tip.DogHubTip;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@Getter
@Setter
public class DogHubUser extends NamedEntity {

    public static final int USER_NAME_MAX_LENGTH = 128;

    public static final int EMAIL_MAX_LENGTH = 128;

    public static final int TITLE_MAX_LENGTH = 64;

    public static final int MOBILE_NUMBER_MAX_LENGTH = 64;

    public static final int THUMBNAIL_PICTURE_MAX_LENGTH = 1024;

    public static final int COMPANY_MAX_LENGTH = 64;

    public static final int PASSWORD_MAX_LENGTH = 64;

    @NotNull @Size(max = USER_NAME_MAX_LENGTH)
    @Column(unique=true)
    private String username;

    @Size(max = EMAIL_MAX_LENGTH) @Email
    private String email;

    @Size(max = TITLE_MAX_LENGTH)
    private String title;

    @Size(max = THUMBNAIL_PICTURE_MAX_LENGTH) @URL
    private String thumbnailPicture;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @Past
    private ZonedDateTime dateOfBirth;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @Past
    private ZonedDateTime dateOfRegistration;

    @Size(max = COMPANY_MAX_LENGTH)
    private String company;

    @Embedded
    private DogHubAddress address;

    @Size(max = MOBILE_NUMBER_MAX_LENGTH)
    private String mobileNumber;

    @JsonIgnore
    @NotNull @Size(max = PASSWORD_MAX_LENGTH)
    private String hashedPassword;

    @PositiveOrZero
    private Long likes = 0L;

    @PositiveOrZero
    private Long comments = 0L;

    @PositiveOrZero
    private Long shares = 0L;

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.EAGER)
    private List<DogHubTip> dogHubTips;

    @NotNull
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
