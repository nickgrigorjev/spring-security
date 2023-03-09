package com.nsgrigorjev.springsecurity.service;

import com.nsgrigorjev.springsecurity.models.Person;
import com.nsgrigorjev.springsecurity.repositories.PeopleRepository;
import com.nsgrigorjev.springsecurity.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PersonDetailsServiceImpl implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByUsername(username);

        if(person.isEmpty()) {
            throw new UsernameNotFoundException("User: "+username + " not found");
        }

        return new PersonDetails(person.get());
    }
}
