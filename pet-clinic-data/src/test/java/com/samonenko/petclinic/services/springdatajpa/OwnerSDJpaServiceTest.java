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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @InjectMocks
    private OwnerSDJpaService service;

    @Mock
    private OwnerRepository ownerRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findByLastName() {
        Owner returnOwner = Owner.builder().id(1L).lastName("Smith").build();



        Owner smith = service.findByLastName("Smith");
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}