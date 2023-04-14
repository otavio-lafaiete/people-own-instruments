package com.lafaiete.peopleowninstruments.controller;

import com.lafaiete.peopleowninstruments.entity.Instrument;
import com.lafaiete.peopleowninstruments.entity.Person;
import com.lafaiete.peopleowninstruments.entity.form.PersonForm;
import com.lafaiete.peopleowninstruments.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    public Person create(@Valid @RequestBody PersonForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<Person> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                              String dataDeNacimento){
        return service.getAll(dataDeNacimento);
    }

    @GetMapping("/{id}")
    public Person get(@PathVariable("id") Long id){
        return service.get(id);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable("id") Long id, @Valid @RequestBody PersonForm form){
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

    @GetMapping("instruments/{id}")
    public List<Instrument> getAllInstruments(@PathVariable("id") Long id){
        return service.getAllInstrumentsId(id);
    }

    @PostMapping("instruments/{id_person}/{id_instrument}")
    public Person addInstrument(@PathVariable("id_person") Long id_person,
                                @PathVariable("id_instrument") Long id_instrument){
        return service.addInstrument(id_person, id_instrument);
    }
}
