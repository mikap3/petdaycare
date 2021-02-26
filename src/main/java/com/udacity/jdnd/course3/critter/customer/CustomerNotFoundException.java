package com.udacity.jdnd.course3.critter.customer;

import com.udacity.jdnd.course3.critter.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Customer not found")
public class CustomerNotFoundException extends ResourceNotFoundException {

}
