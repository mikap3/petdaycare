package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.employee.EmployeeSkill;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Represents the form that schedule request and response data takes. Does not map
 * to the database directly.
 */
@Getter @Setter
@NoArgsConstructor
public class ScheduleDTO {

    private Long id;

    @NotEmpty
    private List<Long> employeeIds = new ArrayList<>();

    @NotEmpty
    private List<Long> petIds = new ArrayList<>();

    @NotNull
    private LocalDate date;

    private Set<EmployeeSkill> activities;
}
