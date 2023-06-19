package com.glo.uservalidation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddress {

    @Id
    private int addresId;
    @NotBlank(message = "Address is mandatory")
    @Size(min = 5, max = 25)
    private String address;
    @NotBlank(message = "city is mandatory")
    private String city;
    @NotNull(message = "pincode is mandatory")
    private int pinCode;
    @NotBlank(message = "state is mandatory")
    private String state;
}
