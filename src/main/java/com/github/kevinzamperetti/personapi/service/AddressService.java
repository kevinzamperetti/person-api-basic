package com.github.kevinzamperetti.personapi.service;

import com.github.kevinzamperetti.personapi.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    List<Address> findAll();

    Optional<Address> findById(Long id);

    void deleteById(Long id);

    Address save(Address address);
}
