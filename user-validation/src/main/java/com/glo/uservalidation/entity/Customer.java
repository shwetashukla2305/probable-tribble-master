package com.glo.uservalidation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @NotBlank(message = "Id is mandatory")
    private long uniqueIdNumber;
    @NotBlank(message = "Dob is mandatory")
    private String dateOfBirth;
    @NotBlank(message = "Email address is mandatory")
    @Email
    private String emailAddress;
    @NotBlank(message = "First name is mandatory")
    @Size(min = 5, max = 15)
    private String firstName;
    @NotBlank(message = "Last Name is mandatory")
    @Size(min = 5, max = 15)
    private String lastName;
    @NotBlank(message = "Id type is mandatory")
    private String idType;
    @OneToOne
    private CustomerAddress customerAddress;
    private int simId;
    @NotBlank(message = "State is mandatory")
    private String state;

}
