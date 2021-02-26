package com.udacity.jdnd.course3.critter.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.udacity.jdnd.course3.critter.schedule.Schedule;
import com.udacity.jdnd.course3.critter.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Employee extends User {

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<EmployeeSkill> skills;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private Set<DayOfWeek> daysAvailable;

    @ManyToMany(mappedBy = "employees", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Schedule> schedules = new ArrayList<>();
}
