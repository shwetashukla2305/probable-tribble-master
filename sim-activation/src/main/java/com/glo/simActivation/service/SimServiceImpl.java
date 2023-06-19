package com.glo.simActivation.service;

import com.glo.simActivation.dto.SIMValidationDto;
import com.glo.simActivation.entity.SimDetails;
import com.glo.simActivation.entity.SimOffers;
import com.glo.simActivation.exception.InvalidSimDetailsException;
import com.glo.simActivation.exception.InvalidSimidException;
import com.glo.simActivation.exception.SIMAlreadyActiveException;
import com.glo.simActivation.repository.SimDetailsRepository;
import com.glo.simActivation.repository.SimOffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SimServiceImpl implements SimService{

    @Autowired
    SimDetailsRepository simDetailsRepository;

    @Autowired
    SimOffersRepository simOffersRepository;


    @Override
    public String validateSIM(SIMValidationDto simValidationDto) {
        SimDetails simDetails = simDetailsRepository.findByServiceNumberAndSimNumber(simValidationDto.getServiceNumber(), simValidationDto.getSimNumber());
        if(simDetails != null){
            if(simDetails.getSimStatus().equalsIgnoreCase("Active")){
                return "SIM already active";
            }else if(simDetails.getSimStatus().equalsIgnoreCase("Inactive")){
                return "Valid details. Welcome!!. The SIM Id is : "+simDetails.getSimId();
            }
        } else {
            throw new InvalidSimDetailsException("Invalid SIM details !!");
        }
        return null;
    }

    @Override
    public String showOffers(int simId) {
        SimOffers simOffers = simOffersRepository.findOffersBySimId(simId);
        if(simOffers == null)
            throw new InvalidSimidException("Sorry !!. This SIM has no offers");
        return simOffers.getCallQty()+" calls  "+ simOffers.getDataQty()+" GB for Rs."+simOffers.getCost()+", Validity : "+simOffers.getDuration()+" days.";
    }

    @Override
    public SimDetails getDetails(int simId) {
        Optional<SimDetails> simDetailsOpt = simDetailsRepository.findById(simId);
        if(simDetailsOpt.isPresent()){
            SimDetails simDetails = simDetailsOpt.get();
            return simDetails;
        }
        return null;
    }

    @Override
    public String activateSIM(int simId) {
        Optional<SimDetails> simDetailsOpt = simDetailsRepository.findById(simId);
        if(simDetailsOpt.isPresent()){
            SimDetails simDetails = simDetailsOpt.get();
            if(!simDetails.getSimStatus().equalsIgnoreCase("active")){
                int updateCount = simDetailsRepository.updateSIMStatus(simId);
                if(updateCount==1)
                    return "Success !! SIM is activated";
            }else {
                throw new SIMAlreadyActiveException("The SIM is already activated!");
            }
        }else {
            throw new InvalidSimidException("Given SIM id not found");
        }
        return null;
    }
}
