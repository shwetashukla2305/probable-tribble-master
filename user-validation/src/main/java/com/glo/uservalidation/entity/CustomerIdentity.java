package com.glo.uservalidation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerIdentity {

    @Id
    private long uniqueIdNumber;
    @NotBlank(message = "DOB is mandatory")
    private String dateOfBirth;
    @NotBlank(message = "Email address is mandatory")
    @Email
    private String emailAddress;
    @NotBlank(message = "First name is mandatory")
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
    @NotBlank(message = "State is mandatory")
    private String state;
}
