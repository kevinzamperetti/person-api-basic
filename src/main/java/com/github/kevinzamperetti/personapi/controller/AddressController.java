package com.github.kevinzamperetti.personapi.controller;

import com.github.kevinzamperetti.personapi.entity.Address;
import com.github.kevinzamperetti.personapi.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("addresses")
public class AddressController {

    private AddressService service;

    public AddressController(AddressService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAll() {
        List<Address> allAddress = service.findAll();
        return ResponseEntity.ok(allAddress);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Address>> getById(@PathVariable("id") Long id) {
        Optional<Address> address = service.findById(id);
        if (address.isPresent()) {
            return ResponseEntity.ok(address);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Address> save(@RequestBody Address address) {
        service.save(address);
        return new ResponseEntity(address, HttpStatus.CREATED);
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
