package com.samonenko.petclinic.services.map;

import com.samonenko.petclinic.model.Speciality;
import com.samonenko.petclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {
}
