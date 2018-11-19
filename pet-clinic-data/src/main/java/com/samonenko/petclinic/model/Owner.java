package com.samonenko.petclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Owner extends Person {

    private String city;

    private String address;

    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    Set<Pet> pets = new HashSet<>();

    @Builder
    public Owner(String city, String address, String telephone, Set<Pet> pets, String firstName, String lastName, Long id) {
        super(id, firstName, lastName);
        this.city = city;
        this.address = address;
        this.telephone = telephone;
        this.pets = pets;
    }
}
