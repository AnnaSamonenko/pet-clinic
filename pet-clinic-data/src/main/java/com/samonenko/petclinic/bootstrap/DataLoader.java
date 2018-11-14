package com.samonenko.petclinic.bootstrap;

import com.samonenko.petclinic.model.*;
import com.samonenko.petclinic.services.OwnerService;
import com.samonenko.petclinic.services.PetTypeService;
import com.samonenko.petclinic.services.SpecialityService;
import com.samonenko.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0)
            loadData();
    }

    public void loadData() {
        PetType dog = new PetType();
        dog.setType("dog");
        PetType savedDogType = petTypeService.save(dog);
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        PetType cat = new PetType();
        cat.setType("cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("464 Berkly st");
        owner1.setCity("Miami");
        owner1.setTelephone("565-554-586-553");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Fluffy");
        mikesPet.setOwner(owner1);

        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("888 Harvy st");
        owner2.setCity("Miami");
        owner2.setTelephone("765-554-586-553");

        Pet fionaPet = new Pet();
        fionaPet.setPetType(savedCatType);
        fionaPet.setBirthDate(LocalDate.now());
        fionaPet.setName("Kitty");
        fionaPet.setOwner(owner2);

        owner2.getPets().add(fionaPet);

        ownerService.save(owner2);

        System.out.print("Owners loaded....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Ave");
        vet1.getSpecialities().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Anna");
        vet2.setLastName("Bronx");
        vet2.getSpecialities().add(savedRadiology);

        vetService.save(vet2);

        System.out.println("Vet loaded....");
    }
}
