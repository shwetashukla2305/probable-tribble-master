package com.glo.uservalidation.service;

import com.glo.uservalidation.dto.BasicDetailValidationDto;
import com.glo.uservalidation.dto.PersonalDetailValidationDto;
import com.glo.uservalidation.entity.Customer;
import com.glo.uservalidation.entity.CustomerAddress;
import com.glo.uservalidation.entity.CustomerIdentity;
import com.glo.uservalidation.entity.TermsConditions;

public interface CustomerService {

    String validateBasicDetails(BasicDetailValidationDto basicDetailvalidationDto);

    String validatePersonalDetails(PersonalDetailValidationDto personalDetailValidationDto);

    CustomerAddress customerAddressUpdation(CustomerAddress customerAddress, long uniqueId);
    String customerIdentityValidation(CustomerIdentity customerIdentity);


    int getCustomerSIMIdById(long uniqueId);
    Customer getCustomerById(long uniqueId);
}
