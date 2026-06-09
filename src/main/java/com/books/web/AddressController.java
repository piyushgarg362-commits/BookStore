package com.books.web;

import com.books.model.Address;
import com.books.repo.AddressRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AddressController {
    private final AddressRepository repository;

    @Autowired
    public AddressController(AddressRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/address/list")
    public List<Address> getAddressList() {
        return repository.findAll();
    }

    @GetMapping("/address/{id}")
    public Address getAddress(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/address/{id}/delete")
    public void deleteAddress(@PathVariable Long id) {
        repository.deleteById(id);
    }
}