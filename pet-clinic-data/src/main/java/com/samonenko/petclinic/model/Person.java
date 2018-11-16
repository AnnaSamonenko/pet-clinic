package com.samonenko.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@MappedSuperclass
public class Person extends BaseEntity {

    @NotEmpty
    private String firstName;

    private String lastName;
}
