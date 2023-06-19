package com.glo.uservalidation.controller;

import com.glo.uservalidation.dto.ActivateSIMDto;
import com.glo.uservalidation.dto.BasicDetailValidationDto;
import com.glo.uservalidation.dto.PersonalDetailValidationDto;
import com.glo.uservalidation.entity.Customer;
import com.glo.uservalidation.entity.CustomerAddress;
import com.glo.uservalidation.entity.CustomerIdentity;
import com.glo.uservalidation.entity.TermsConditions;
import com.glo.uservalidation.exception.SIMAlreadyActiveException;
import com.glo.uservalidation.exception.TermsNotAcceptedException;
import com.glo.uservalidation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user-validation")
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    CustomerService customerService;

    @PostMapping("/validateBasicdetails")
    public ResponseEntity<String> validateCustomerBasicDetails(@RequestBody BasicDetailValidationDto basicDetailvalidationDto) {
        return new ResponseEntity<>(customerService.validateBasicDetails(basicDetailvalidationDto), HttpStatus.ACCEPTED);
    }

    @PostMapping("/validatePersonalDetails")
    public ResponseEntity<String> validateCustomerPersonalDetails(@RequestBody PersonalDetailValidationDto personalDetailValidationDto) {
        return new ResponseEntity<>(customerService.validatePersonalDetails(personalDetailValidationDto), HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateAddress/{uniqueId}")
    public ResponseEntity<CustomerAddress> updateCustomerAddress(@RequestBody CustomerAddress customerAddress, @PathVariable long uniqueId) {
        return new ResponseEntity<>(customerService.customerAddressUpdation(customerAddress, uniqueId), HttpStatus.OK);
    }

    @PostMapping("/validateIdentity")
    public ResponseEntity<String> validateCustomerIdentity(@RequestBody CustomerIdentity customerIdentity) {
        return new ResponseEntity<>(customerService.customerIdentityValidation(customerIdentity), HttpStatus.ACCEPTED);
    }

    @GetMapping("/showSummary/{uniqueId}")
    public ResponseEntity<String> showOrderSummary(@PathVariable long uniqueId){
        int simId = customerService.getCustomerSIMIdById(uniqueId);
        String url = "http://sim-activation:8081/sim-activation/getDetails/"+simId;
        String simDetails = restTemplate.getForObject(url, String.class);
        Customer customer = customerService.getCustomerById(uniqueId);
        String customerDetails = "The Customer details are : \n First Name : "+customer.getFirstName()+" \n Last Name : "+customer.getLastName()+" \n Email Address : "+customer.getEmailAddress()+" \n Date Of Birth : "+customer.getDateOfBirth();
        String summary = simDetails + " \n "+customerDetails;
        return new ResponseEntity<>(summary, HttpStatus.OK);
    }

    @PostMapping("/activateSIM")
    public ResponseEntity<String> activateSIM(@RequestBody ActivateSIMDto activateSIMDto){
        if(activateSIMDto.getTermsConditions().equals(TermsConditions.AGREE)){
            int simId = customerService.getCustomerSIMIdById(activateSIMDto.getUniqueId());
            String url = "http://sim-activation:8081/sim-activation/activateSIM/"+simId;
            ResponseEntity<String> response = null;
            try{
                response = restTemplate.exchange(url,  HttpMethod.PATCH, null, String.class);
                System.out.println(response);
            } catch (Exception e){
                if(e.getMessage().contains("The SIM is already activated!"))
                    throw new SIMAlreadyActiveException("The SIM is already activated!");
            }
            return response;
        } else {
            throw new TermsNotAcceptedException("Accept the terms and conditions to activate the SIM!!");
        }
    }
}
