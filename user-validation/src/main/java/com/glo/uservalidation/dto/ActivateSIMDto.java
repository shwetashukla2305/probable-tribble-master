package com.glo.uservalidation.dto;

import com.glo.uservalidation.entity.TermsConditions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivateSIMDto {

    @NotBlank(message = "SIM Id is mandatory to activate")
    private long uniqueId;
    private TermsConditions termsConditions;
}


