package com.samonenko.petclinic.services.map;

import com.samonenko.petclinic.model.Vet;
import com.samonenko.petclinic.services.OwnerService;
import com.samonenko.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
}
