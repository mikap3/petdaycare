package com.udacity.jdnd.course3.critter.employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.DayOfWeek;
import java.util.Set;

/**
 * Represents the form that employee request and response data takes. Does not map
 * to the database directly.
 */
@Getter @Setter
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotEmpty
    private Set<EmployeeSkill> skills;

    @NotEmpty
    private Set<DayOfWeek> daysAvailable;
}
