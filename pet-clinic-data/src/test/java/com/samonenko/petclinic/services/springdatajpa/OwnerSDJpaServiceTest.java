package com.samonenko.petclinic.services.springdatajpa;

import com.samonenko.petclinic.model.Owner;
import com.samonenko.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    static final String LAST_NAME = "Smith";
    static final Long ID = 1L;

    @InjectMocks
    private OwnerSDJpaService service;

    @Mock
    private OwnerRepository ownerRepository;

    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(ID).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        Mockito.when(ownerRepository.findByLastName(Mockito.any())).thenReturn(owner);

        Owner smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());

        Mockito.verify(ownerRepository, Mockito.times(1)).findByLastName(LAST_NAME);
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(owner);
        owners.add(Owner.builder().id(2L).build());

        Mockito.when(ownerRepository.findAll()).thenReturn(owners);

        assertEquals(owners, service.findAll());
        Mockito.verify(ownerRepository, Mockito.times(1)).findAll();
    }

    @Test
    void findById() {
        Mockito.when(ownerRepository.findById(ID)).thenReturn(Optional.of(owner));

        assertEquals(owner, service.findById(ID));

        Mockito.verify(ownerRepository, Mockito.times(1)).findById(ID);
    }

    @Test
    void findByNotPresentId() {
        Mockito.when(ownerRepository.findById(ID)).thenReturn(Optional.empty());

        assertNull(service.findById(ID));

        Mockito.verify(ownerRepository, Mockito.times(1)).findById(ID);
    }

    @Test
    void save() {
        Mockito.when(ownerRepository.save(owner)).thenReturn(owner);

        assertEquals(owner, service.save(owner));
        Mockito.verify(ownerRepository, Mockito.times(1)).save(owner);
    }

    @Test
    void delete() {
        service.delete(owner);
        Mockito.verify(ownerRepository).delete(Mockito.any());
    }

    @Test
    void deleteById() {
        service.deleteById(owner.getId());
        Mockito.verify(ownerRepository).deleteById(Mockito.any());
    }
}