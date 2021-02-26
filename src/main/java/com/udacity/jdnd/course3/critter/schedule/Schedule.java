package com.udacity.jdnd.course3.critter.schedule;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.employee.Employee;
import com.udacity.jdnd.course3.critter.employee.EmployeeSkill;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "schedule_employee",
            joinColumns = {@JoinColumn(name = "schedule_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")}
    )
    @JsonManagedReference
    private List<Employee> employees = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "schedule_pet",
            joinColumns = {@JoinColumn(name = "schedule_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "pet_id", referencedColumnName = "id")}
    )
    @JsonManagedReference
    private List<Pet> pets = new ArrayList<>();

    private LocalDate date;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<EmployeeSkill> activities;

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.getSchedules().add(this);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        employee.getSchedules().remove(this);
    }

    public void addPet(Pet pet) {
        pets.add(pet);
        pet.getSchedules().add(this);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
        pet.getSchedules().remove(this);
    }
}
