package com.samonenko.petclinic.services.map;

import com.samonenko.petclinic.model.Speciality;
import com.samonenko.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {
}
