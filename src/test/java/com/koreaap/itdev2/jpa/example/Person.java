package com.koreaap.itdev2.jpa.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@Entity
@Builder
@Getter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
interface PersonRepository extends Repository<Person, Long> {

    Person save(Person person);

    Optional<Person> findById(long id);
}
