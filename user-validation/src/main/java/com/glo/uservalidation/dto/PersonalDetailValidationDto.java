package com.glo.uservalidation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDetailValidationDto {

    @NotBlank(message = "First name is mandatory")
    @Size(min = 5, max = 15)
    private String firstName;
    @Size(min = 5, max = 15)
    @NotBlank(message = "Last name is mandatory")
    private String lastname;
    @Email
    @NotBlank(message = "Confirm email is mandatory")
    private String confirmEmail;
}
