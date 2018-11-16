package com.samonenko.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Owner extends Person {

    @Getter
    @Setter
    private String city;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private String telephone;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    Set<Pet> pets = new HashSet<>();

}
