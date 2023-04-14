package com.lafaiete.peopleowninstruments.entity.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class InstrumentForm {

    @NotEmpty(message = "Preencha o campo corretamente.")
    @Size(min = 3, max =50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String type;

    @NotEmpty(message = "Preencha o campo corretamente.")
    @Size(min = 3, max =50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String Colour;

    @NotNull(message = "Prencha o campo corretamente.")
    @Past(message = "Data '${validatedValue}' é inválida.")
    private LocalDate manufacturingDate;
}
