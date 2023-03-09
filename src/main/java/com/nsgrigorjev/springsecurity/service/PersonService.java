package com.nsgrigorjev.springsecurity.service;

import com.nsgrigorjev.springsecurity.models.Person;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public interface PersonService {
    Optional<Person> findByUsername(String username);
}
