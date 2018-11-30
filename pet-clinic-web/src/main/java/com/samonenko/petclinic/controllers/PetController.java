package com.samonenko.petclinic.controllers;

import com.samonenko.petclinic.model.Owner;
import com.samonenko.petclinic.model.PetType;
import com.samonenko.petclinic.services.OwnerService;
import com.samonenko.petclinic.services.PetService;
import com.samonenko.petclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private final PetService petService;

    private final OwnerService ownerService;

    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> getPetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner getOwner(@PathVariable("ownerId") Long id) {
        return ownerService.findById(id);
    }
}
