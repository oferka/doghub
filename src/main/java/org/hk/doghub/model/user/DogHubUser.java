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

    @NotNull
    @Size(min = 5, max = 128)
    @NotBlank
    @Column(unique=true)
    private String username;

    @Email
    private String email;

    @Size(min = 2, max = 64)
    private String title;

    @URL
    private String thumbnailPicture;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @Past
    private ZonedDateTime dateOfBirth;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @Past
    private ZonedDateTime dateOfRegistration;

    @Size(min = 2, max = 64)
    private String company;

    @Embedded
    private DogHubAddress address;

    @Size(min = 2, max = 64)
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
