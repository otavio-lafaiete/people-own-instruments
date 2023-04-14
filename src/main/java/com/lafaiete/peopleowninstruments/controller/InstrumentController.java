package com.lafaiete.peopleowninstruments.controller;

import com.lafaiete.peopleowninstruments.entity.Instrument;
import com.lafaiete.peopleowninstruments.entity.form.InstrumentForm;
import com.lafaiete.peopleowninstruments.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/instruments")
public class InstrumentController {

    @Autowired
    private InstrumentService service;

    @PostMapping
    public Instrument create(@Valid @RequestBody InstrumentForm form){
        return service.create(form);
    }

    @GetMapping("/{id}")
    public Instrument get(@PathVariable("id") Long instrumentId){
        return service.get(instrumentId);
    }

    @PutMapping("/{id}")
    public Instrument update(@PathVariable("id") Long id, @Valid @RequestBody InstrumentForm formUpdate){
        return service.update(id, formUpdate);
    };

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    };
}
