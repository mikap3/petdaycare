package com.udacity.jdnd.course3.critter.customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the form that customer request and response data takes. Does not map
 * to the database directly.
 */
@Getter @Setter
@NoArgsConstructor
public class CustomerDTO {

    private Long id;

    @NotBlank
    private String name;

    private String phoneNumber;

    private String notes;

    private List<Long> petIds = new ArrayList<>();
}
