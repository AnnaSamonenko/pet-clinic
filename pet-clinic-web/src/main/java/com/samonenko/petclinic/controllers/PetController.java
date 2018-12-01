package com.samonenko.petclinic.controllers;

import com.samonenko.petclinic.model.Owner;
import com.samonenko.petclinic.model.Pet;
import com.samonenko.petclinic.model.PetType;
import com.samonenko.petclinic.services.OwnerService;
import com.samonenko.petclinic.services.PetService;
import com.samonenko.petclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, Model model) {
        Pet pet = new Pet();
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, Model model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.getPets().add(pet);
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return "pets/createOrUpdatePetForm";
        } else {
            petService.save(pet);
            return "redirect:/owners/{ownerId}";
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable Long petId, Model model) {
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@PathVariable Long petId, @Valid Pet pet, Owner owner,
                                    BindingResult result, Model model) {
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return "pets/createOrUpdatePetForm";
        } else {
            owner.getPets().add(pet);
            petService.save(pet);
            return "redirect:/owners/{ownerId}";
        }
    }
}
