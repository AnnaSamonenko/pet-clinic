package com.samonenko.petclinic.services.map;

import com.samonenko.petclinic.model.PetType;
import com.samonenko.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
