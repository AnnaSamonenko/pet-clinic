package com.samonenko.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class Speciality extends BaseEntity {

    @Getter
    @Setter
    private String description;

}
