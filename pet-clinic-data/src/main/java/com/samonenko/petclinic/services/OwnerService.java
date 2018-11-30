package com.samonenko.petclinic.services;

import com.samonenko.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String searchRequest);
}
