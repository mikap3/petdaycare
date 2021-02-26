package com.udacity.jdnd.course3.critter.employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

/**
 * Represents a request to find available employees by skills. Does not map
 * to the database directly.
 */
@Getter @Setter
@NoArgsConstructor
public class EmployeeRequestDTO {

    private Set<EmployeeSkill> skills;

    @NotNull
    private LocalDate date;
}
