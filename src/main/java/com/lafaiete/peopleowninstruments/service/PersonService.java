package com.lafaiete.peopleowninstruments.service;

import com.lafaiete.peopleowninstruments.entity.Instrument;
import com.lafaiete.peopleowninstruments.entity.Person;
import com.lafaiete.peopleowninstruments.entity.form.PersonForm;

import java.util.List;

public interface PersonService {

    Person create(PersonForm form);

    Person get(Long id);

    List<Person> getAll(String dataDeNascimento);

    Person update(Long id, PersonForm formUpdate);

    void delete(Long id);

    List<Instrument> getAllInstrumentsId(Long id);

    Person addInstrument(Long personId, Long intrumentId);
}

