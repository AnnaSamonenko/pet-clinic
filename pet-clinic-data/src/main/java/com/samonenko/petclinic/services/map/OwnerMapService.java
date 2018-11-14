package com.samonenko.petclinic.services.map;

import com.samonenko.petclinic.model.Owner;
import com.samonenko.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
