package com.samonenko.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Owner extends Person {

    private String city;

    private String address;

    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    Set<Pet> pets = new HashSet<>();
}
