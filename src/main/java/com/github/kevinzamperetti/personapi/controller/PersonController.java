package com.github.kevinzamperetti.personapi.controller;

import com.github.kevinzamperetti.personapi.entity.Person;
import com.github.kevinzamperetti.personapi.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        List<Person> allPerson = service.findAll();
        return ResponseEntity.ok(allPerson);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Person>> getById(@PathVariable("id") Long id) {
        Optional<Person> person = service.findById(id);
        if (person.isPresent()) {
            return ResponseEntity.ok(person);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        service.save(person);
        return new ResponseEntity(person, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }



}
