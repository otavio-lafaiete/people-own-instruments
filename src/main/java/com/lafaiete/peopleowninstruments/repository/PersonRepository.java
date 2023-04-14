package com.lafaiete.peopleowninstruments.repository;

import com.lafaiete.peopleowninstruments.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.time.LocalDate;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByBirthDate(LocalDate birthData);
}
