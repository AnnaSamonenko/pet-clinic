package com.samonenko.petclinic.services.map;

import com.samonenko.petclinic.model.Visit;
import com.samonenko.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit save(Visit object) {
        if (object.getPet() == null || object.getPet().getOwner() == null || object.getPet().getId() == null
                || object.getPet().getOwner().getId() == null)
            throw new RuntimeException("Invalid Exception");
        return super.save(object);
    }
}
