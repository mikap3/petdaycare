package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.customer.Customer;
import com.udacity.jdnd.course3.critter.customer.CustomerNotFoundException;
import com.udacity.jdnd.course3.critter.customer.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PetService {

    private final PetRepository petRepository;
    private final CustomerRepository customerRepository;

    public PetService(PetRepository petRepository, CustomerRepository customerRepository) {
        this.petRepository = petRepository;
        this.customerRepository = customerRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet getPetById(Long petId) throws PetNotFoundException {
        return petRepository.findById(petId).orElseThrow(PetNotFoundException::new);
    }

    public void savePet(Pet pet) {
        pet.getOwner().getPets().add(pet);
        petRepository.save(pet);
    }

    public List<Pet> getPetsByOwner(Long ownerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(ownerId).orElseThrow(CustomerNotFoundException::new);
        return customer.getPets();
    }
}
