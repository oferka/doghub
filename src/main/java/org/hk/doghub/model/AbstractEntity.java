package org.hk.doghub.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.ZonedDateTime;

@MappedSuperclass
@ToString
public abstract class AbstractEntity implements Serializable {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @Getter
    @Setter
    @Past
    private ZonedDateTime creationTime;

    @Version
    @Getter
    private int version;
}
