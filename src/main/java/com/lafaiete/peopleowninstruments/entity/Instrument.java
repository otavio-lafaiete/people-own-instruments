package com.lafaiete.peopleowninstruments.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_isntruments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeInstrument;
    private String Colour;
    private LocalDate manufacturingDate;
}
