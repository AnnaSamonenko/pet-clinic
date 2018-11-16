package com.samonenko.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class PetType extends BaseEntity {

    @Getter
    @Setter
    private String type;
}
