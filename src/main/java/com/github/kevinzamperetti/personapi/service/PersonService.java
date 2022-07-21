package com.github.kevinzamperetti.personapi.service;

import com.github.kevinzamperetti.personapi.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<Person> findAll();

    Optional<Person> findById(Long id);

    void deleteById(Long id);

    Person save(Person person);
}
