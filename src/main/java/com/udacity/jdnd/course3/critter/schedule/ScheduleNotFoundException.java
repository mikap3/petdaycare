package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Schedule not found")
public class ScheduleNotFoundException extends ResourceNotFoundException {

}
