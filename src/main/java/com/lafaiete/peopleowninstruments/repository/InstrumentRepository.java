package com.lafaiete.peopleowninstruments.repository;

import com.lafaiete.peopleowninstruments.entity.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
}
