package com.udacity.jdnd.course3.critter.employee;

import com.udacity.jdnd.course3.critter.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Employee not found")
public class EmployeeNotFoundException extends ResourceNotFoundException {

}
