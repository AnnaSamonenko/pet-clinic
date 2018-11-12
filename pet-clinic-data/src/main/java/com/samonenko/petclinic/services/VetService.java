package com.samonenko.petclinic.services;

import com.samonenko.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Vet vet);

    Vet save(Vet vet);

    Set<Vet> findAll();

}
