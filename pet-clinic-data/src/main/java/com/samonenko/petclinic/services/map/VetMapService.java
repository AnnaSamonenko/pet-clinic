package com.samonenko.petclinic.services.map;

import com.samonenko.petclinic.model.Speciality;
import com.samonenko.petclinic.model.Vet;
import com.samonenko.petclinic.services.OwnerService;
import com.samonenko.petclinic.services.SpecialityService;
import com.samonenko.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }

        return super.save(object);
    }
}
