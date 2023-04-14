package com.lafaiete.peopleowninstruments.service.impl;

import com.lafaiete.peopleowninstruments.entity.Instrument;
import com.lafaiete.peopleowninstruments.entity.Person;
import com.lafaiete.peopleowninstruments.entity.form.PersonForm;
import com.lafaiete.peopleowninstruments.infra.utils.JavaTimeUtils;
import com.lafaiete.peopleowninstruments.repository.PersonRepository;
import com.lafaiete.peopleowninstruments.service.InstrumentService;
import com.lafaiete.peopleowninstruments.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private InstrumentService instrumentService;

    @Override
    public Person create(PersonForm form) {
        Person person = new Person();
        person.setName(form.getName());
        person.setBirthDate(form.getBirthDate());

        return repository.save(person);
    }

    @Override
    public Person get(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Person> getAll(String dataDeNascimento) {

        if(dataDeNascimento == null) {
            return repository.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repository.findByBirthDate(localDate);
        }

    }

    @Override
    public Person update(Long id, PersonForm formUpdate) {
        Person person = repository.getById(id);
        person.setName(formUpdate.getName());
        person.setBirthDate(formUpdate.getBirthDate());
        if(person != null)
            return repository.save(person);
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Instrument> getAllInstrumentsId(Long id) {
        Person person = repository.getById(id);
        return person.getInstruments();
    }

    @Override
    public Person addInstrument(Long personId, Long intrumentId){
        Person person = repository.getById(personId);
        Instrument instrument = instrumentService.get(intrumentId);
        person.getInstruments().add(instrument);
        if(person == null || instrument == null)
            return null;
        return repository.save(person);
    }
}
