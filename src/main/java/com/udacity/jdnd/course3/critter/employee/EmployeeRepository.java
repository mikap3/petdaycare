package com.udacity.jdnd.course3.critter.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.util.Set;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Set<Employee> findBySkillsContainingAndDaysAvailableContaining(EmployeeSkill skill, DayOfWeek day);
}
