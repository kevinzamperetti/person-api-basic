package com.github.kevinzamperetti.personapi.repository;

import com.github.kevinzamperetti.personapi.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAll();

    Optional<Address> findById(Long id);

}
