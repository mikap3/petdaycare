package com.udacity.jdnd.course3.critter.pet;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

/**
 * Represents the form that pet request and response data takes. Does not map
 * to the database directly.
 */
@Getter @Setter
@NoArgsConstructor
public class PetDTO {

    private Long id;

    @NotNull
    private PetType type;

    @NotBlank
    private String name;

    @NotNull
    private Long ownerId;

    @Past
    private LocalDate birthDate;

    private String notes;
}
