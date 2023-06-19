package com.glo.simActivation.controller;

import com.glo.simActivation.dto.SIMValidationDto;
import com.glo.simActivation.entity.SimDetails;
import com.glo.simActivation.service.SimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sim-activation")
public class SimController {

    @Autowired
    SimService simService;

    @PostMapping("/validateSIM")
    public ResponseEntity<String> validateSIM(@RequestBody SIMValidationDto simValidationDto) {
        return new ResponseEntity<>( simService.validateSIM(simValidationDto), HttpStatus.ACCEPTED);
    }

    @GetMapping("/showOffers/{simId}")
    public ResponseEntity<String> showOffers(@PathVariable int simId){
        return new ResponseEntity<>(simService.showOffers(simId), HttpStatus.OK);
    }

    @GetMapping("/getDetails/{simId}")
    public String getDetails(@PathVariable int simId){
        SimDetails simDetails = simService.getDetails(simId);
        return "The SIM details are : \n SIM Id : "+simId+" \n Service number : "+simDetails.getServiceNumber()+" \n SIM number : "+simDetails.getSimNumber()+" \n SIM status : "+simDetails.getSimStatus();
    }

    @PatchMapping("/activateSIM/{simId}")
    public ResponseEntity<String> activateSIM(@PathVariable int simId){
        return new ResponseEntity<>(simService.activateSIM(simId), HttpStatus.OK);
    }
}
