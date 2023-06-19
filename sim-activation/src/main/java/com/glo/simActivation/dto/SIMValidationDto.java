package com.glo.simActivation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SIMValidationDto {

    @Size(min = 10, max = 10)
    private long serviceNumber;
    @Size(min = 13, max = 13)
    private long simNumber;
}
