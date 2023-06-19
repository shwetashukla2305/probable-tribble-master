package com.glo.uservalidation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicDetailValidationDto {

    @NotBlank(message = "Email address is mandatory")
    @Email
    private String emailAddress;
    @NotBlank(message = "DOB is mandatory")
    private String dateOfBirth;

}
