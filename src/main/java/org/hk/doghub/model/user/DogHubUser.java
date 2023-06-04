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

    public static final int USER_NAME_MIN_LENGTH = 5;
    public static final int USER_NAME_MAX_LENGTH = 128;

    public static final int MOBILE_NUMBER_MIN_LENGTH = 2;
    public static final int MOBILE_NUMBER_MAX_LENGTH = 64;

    public static final int THUMBNAIL_PICTURE_MIN_LENGTH = 5;
    public static final int THUMBNAIL_PICTURE_MAX_LENGTH = 1024;

    public static final int COMPANY_MIN_LENGTH = 2;
    public static final int COMPANY_MAX_LENGTH = 64;

    @NotNull
    @Size(min = USER_NAME_MIN_LENGTH, max = USER_NAME_MAX_LENGTH)
    @NotBlank
    @Column(unique=true)
    private String username;

    @Email
    private String email;

    @Size(min = 2, max = 64)
    private String title;

    @Size(min = THUMBNAIL_PICTURE_MIN_LENGTH, max = THUMBNAIL_PICTURE_MAX_LENGTH)
    @URL
    private String thumbnailPicture;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @Past
    private ZonedDateTime dateOfBirth;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @Past
    private ZonedDateTime dateOfRegistration;

    @Size(min = COMPANY_MIN_LENGTH, max = COMPANY_MAX_LENGTH)
    private String company;

    @Embedded
    private DogHubAddress address;

    @Size(min = MOBILE_NUMBER_MIN_LENGTH, max = MOBILE_NUMBER_MAX_LENGTH)
    private String mobileNumber;

    @JsonIgnore
    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
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
