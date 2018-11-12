package com.samonenko.petclinic.services;

import com.samonenko.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
