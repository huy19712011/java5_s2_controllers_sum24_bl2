package com.example.java5_s2_controllers_sum24_bl2.service;

import com.example.java5_s2_controllers_sum24_bl2.entity.Country;
import com.example.java5_s2_controllers_sum24_bl2.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    final
    CountryRepository repo;

    public CountryService(CountryRepository repo) {
        this.repo = repo;
    }

    public List<Country> findAll() {

        return repo.findAll();
    }
}
