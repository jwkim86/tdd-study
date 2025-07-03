package com.koreaap.itdev2.jpa.example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonService {
    private final PersonRepository personRepository;

    public Person createPerson(String name) {
        Person person = Person.builder().name(name).build();
        return personRepository.save(person);
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }
}
