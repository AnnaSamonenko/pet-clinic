package com.samonenko.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
public class Person extends BaseEntity {

    @Getter
    @Setter
    @NotEmpty
    private String firstName;

    @Getter
    @Setter
    private String lastName;
}
