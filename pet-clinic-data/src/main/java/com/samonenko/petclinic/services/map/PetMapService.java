package com.samonenko.petclinic.services.map;

import com.samonenko.petclinic.model.Pet;
import com.samonenko.petclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
}
