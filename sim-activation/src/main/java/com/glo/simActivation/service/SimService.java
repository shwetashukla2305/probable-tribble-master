package com.glo.simActivation.service;

import com.glo.simActivation.dto.SIMValidationDto;
import com.glo.simActivation.entity.SimDetails;

public interface SimService {

    String validateSIM(SIMValidationDto simValidationDto);

    String showOffers(int simId);

    SimDetails getDetails(int simId);

    String activateSIM(int simId);
}
