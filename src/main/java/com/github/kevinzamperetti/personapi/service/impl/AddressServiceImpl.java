package com.github.kevinzamperetti.personapi.service.impl;

import com.github.kevinzamperetti.personapi.entity.Address;
import com.github.kevinzamperetti.personapi.entity.Person;
import com.github.kevinzamperetti.personapi.repository.AddressRepository;
import com.github.kevinzamperetti.personapi.repository.PersonRepository;
import com.github.kevinzamperetti.personapi.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository repository;

    private PersonRepository personRepository;

    public AddressServiceImpl(AddressRepository repository, PersonRepository personRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
    }

    public List<Address> findAll() {
        return repository.findAll();
    }

    public Optional<Address> findById(Long id) {
        return repository.findById(id);
    }

    public Address save(Address address) {
        Optional<Person> person = personRepository.findById(address.getPerson().getId());
        if (person.isPresent()) {
            return repository.save(address);
        }
        throw new IllegalArgumentException("Person not found ");
    }

    public void deleteById(Long id) {
        Optional<Address> address = repository.findById(id);
        if (address.isPresent()) {
            repository.deleteById(id);
        }
        throw new IllegalArgumentException("Address not found ");
    }

}
