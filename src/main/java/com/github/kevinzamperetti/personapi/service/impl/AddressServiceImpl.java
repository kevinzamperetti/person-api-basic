package com.github.kevinzamperetti.personapi.service.impl;

import com.github.kevinzamperetti.personapi.entity.Address;
import com.github.kevinzamperetti.personapi.repository.AddressRepository;
import com.github.kevinzamperetti.personapi.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository repository;

    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    public List<Address> findAll() {
        return repository.findAll();
    }

    public Optional<Address> findById(Long id) {
        return repository.findById(id);
    }

    public Address save(Address address) {
        return repository.save(address);
    }

    public void deleteById(Long id) {
        Optional<Address> address = repository.findById(id);
        if (address.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Person not found ");
        }
    }

}
