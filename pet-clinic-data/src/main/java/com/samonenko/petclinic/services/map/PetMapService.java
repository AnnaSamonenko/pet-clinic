package com.samonenko.petclinic.services.map;

import com.samonenko.petclinic.model.Pet;
import com.samonenko.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
}
