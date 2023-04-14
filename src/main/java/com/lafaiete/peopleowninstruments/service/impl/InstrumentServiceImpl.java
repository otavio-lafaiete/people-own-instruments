package com.lafaiete.peopleowninstruments.service.impl;

import com.lafaiete.peopleowninstruments.entity.Instrument;
import com.lafaiete.peopleowninstruments.entity.form.InstrumentForm;
import com.lafaiete.peopleowninstruments.repository.InstrumentRepository;
import com.lafaiete.peopleowninstruments.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrumentServiceImpl implements InstrumentService {

    @Autowired
    private InstrumentRepository repository;

    @Override
    public Instrument create(InstrumentForm form) {
        Instrument instrument = new Instrument();
        instrument.setColour(form.getColour());
        instrument.setTypeInstrument(form.getType());
        instrument.setManufacturingDate(form.getManufacturingDate());
        return repository.save(instrument);
    }

    @Override
    public Instrument get(Long id) {
        return repository.getById(id);
    }

    @Override
    public Instrument update(Long id, InstrumentForm formUpdate) {
        Instrument instrument = repository.getById(id);
        instrument.setColour(formUpdate.getColour());
        instrument.setTypeInstrument(formUpdate.getType());
        instrument.setManufacturingDate(formUpdate.getManufacturingDate());
        if(instrument == null)
            return null;
        return repository.save(instrument);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
