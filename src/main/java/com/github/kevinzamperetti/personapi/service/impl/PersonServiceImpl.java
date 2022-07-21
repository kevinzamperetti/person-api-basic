package com.github.kevinzamperetti.personapi.service.impl;

import com.github.kevinzamperetti.personapi.entity.Person;
import com.github.kevinzamperetti.personapi.repository.PersonRepository;
import com.github.kevinzamperetti.personapi.service.PersonService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return repository.findById(id);
    }

    public Person save(Person person) {
        return repository.save(person);
    }

    public void deleteById(Long id) {
        Optional<Person> person = repository.findById(id);
        if (person.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Person not found ");
        }
    }

}
