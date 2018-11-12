package com.samonenko.petclinic.services.map;

import com.samonenko.petclinic.model.Pet;

import java.util.Set;

public class PetMapService extends AbstractMapService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return null;
    }

    @Override
    public void delete(Pet object) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
