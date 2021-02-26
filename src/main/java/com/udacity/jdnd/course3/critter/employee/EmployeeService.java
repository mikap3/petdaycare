package com.udacity.jdnd.course3.critter.employee;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        return employeeRepository.findById(employeeId).orElseThrow(EmployeeNotFoundException::new);
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void setEmployeeDaysAvailable(Long employeeId, Set<DayOfWeek> daysAvailable) throws EmployeeNotFoundException {
        Employee employee = getEmployeeById(employeeId);
        employee.setDaysAvailable(daysAvailable);
        saveEmployee(employee);
    }

    public List<Employee> findEmployeesForService(Set<EmployeeSkill> skills, LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        // find all employees with at least one requested skill and availability at given date
        Set<Employee> employeeSet = new HashSet<>();
        for (EmployeeSkill skill : skills) {
            employeeSet.addAll(employeeRepository.findBySkillsContainingAndDaysAvailableContaining(skill, day));
        }
        // filter employees to retrieve only those which have all requested skills
        List<Employee> employeeList = new ArrayList<>();
        for (Employee e : employeeSet) {
            if (e.getSkills().containsAll(skills)) {
                employeeList.add(e);
            }
        }
        return employeeList;
    }
}
