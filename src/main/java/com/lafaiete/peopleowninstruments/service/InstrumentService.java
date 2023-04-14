package com.lafaiete.peopleowninstruments.service;

import com.lafaiete.peopleowninstruments.entity.Instrument;
import com.lafaiete.peopleowninstruments.entity.form.InstrumentForm;

public interface InstrumentService {

    Instrument create(InstrumentForm form);

    Instrument get(Long id);

    Instrument update(Long id, InstrumentForm formUpdate);

    void delete(Long id);
}
