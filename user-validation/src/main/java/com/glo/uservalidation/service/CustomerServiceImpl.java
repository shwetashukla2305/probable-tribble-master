package com.glo.uservalidation.service;

import com.glo.uservalidation.dto.BasicDetailValidationDto;
import com.glo.uservalidation.dto.PersonalDetailValidationDto;
import com.glo.uservalidation.entity.Customer;
import com.glo.uservalidation.entity.CustomerAddress;
import com.glo.uservalidation.entity.CustomerIdentity;
import com.glo.uservalidation.entity.TermsConditions;
import com.glo.uservalidation.exception.CustomerIdNotFoundException;
import com.glo.uservalidation.exception.InvalidBasicDetailException;
import com.glo.uservalidation.exception.InvalidIdentityDetailException;
import com.glo.uservalidation.exception.InvalidPersonalDetailException;
import com.glo.uservalidation.repository.CustomerAddressRepository;
import com.glo.uservalidation.repository.CustomerIdentityRepository;
import com.glo.uservalidation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerAddressRepository customerAddressRepository;

    @Autowired
    CustomerIdentityRepository customerIdentityRepository;
    @Override
    public String validateBasicDetails(BasicDetailValidationDto basicDetailvalidationDto) {
        Customer customer = customerRepository.findByEmailAddress(basicDetailvalidationDto.getEmailAddress());
        if(customer!=null){
            if(customer.getDateOfBirth().equals(basicDetailvalidationDto.getDateOfBirth()))
                return "Validated";
            else
                throw new InvalidBasicDetailException("Given EmailAddress and DOB combination doesn't exist");
        }else {
            throw new InvalidBasicDetailException("No request placed for you");
        }
    }

    @Override
    public String validatePersonalDetails(PersonalDetailValidationDto personalDetailValidationDto) {
        Customer customer = customerRepository.findByFirstNameAndLastName(personalDetailValidationDto.getFirstName(), personalDetailValidationDto.getLastname());
        if(customer !=null){
            if(customer.getEmailAddress().equals(personalDetailValidationDto.getConfirmEmail()))
                return "Validated";
            else
                throw new InvalidPersonalDetailException("Existing and Confirm email doesn't match!!");
        }else {
            throw new InvalidPersonalDetailException("Invalid details !...No customer with given first name and last name exists!!");
        }
    }

    @Override
    public CustomerAddress customerAddressUpdation(CustomerAddress customerAddress, long uniqueId) {
        Optional<Customer> customerOpt = customerRepository.findById(uniqueId);
        if(customerOpt.isPresent()) {
            Customer customer1 = customerOpt.get();
            CustomerAddress address1 = customer1.getCustomerAddress();
            if(address1!=null){
                int addressId = address1.getAddresId();
                Optional<CustomerAddress> customerAddressOpt = customerAddressRepository.findById(addressId);
                CustomerAddress customerAddress1 = customerAddressOpt.get();
                customerAddress1.setCity(customerAddress.getCity());
                customerAddress1.setAddress(customerAddress.getAddress());
                customerAddress1.setPinCode(customerAddress.getPinCode());
                customerAddress1.setState(customerAddress.getState());
                customerAddressRepository.save(customerAddress1);
                return customerAddress1;
            } else {
                customer1.setCustomerAddress(customerAddress);
                customerRepository.save(customer1);
                return customerAddress;
            }
        }else {
            throw new CustomerIdNotFoundException("No customer Found for given uniqueId!!");
        }
    }

    @Override
    public String customerIdentityValidation(CustomerIdentity customerIdentity) {
        Optional<CustomerIdentity> customerIdentityOpt = customerIdentityRepository.findById(customerIdentity.getUniqueIdNumber());
        if(customerIdentityOpt.isPresent()){
            CustomerIdentity customerIdentity1 = customerIdentityOpt.get();
            if(customerIdentity1.toString().equals(customerIdentity.toString()))
                return "Validated";
            else
                throw new InvalidIdentityDetailException("Identity details provided doesn't match with existing details for giben unique Id!!");

        }else {
            throw new InvalidIdentityDetailException("No Identity details found for given unique id!");
        }
    }

    @Override
    public int getCustomerSIMIdById(long uniqueId) {
        Optional<Customer> customerOpt = customerRepository.findById(uniqueId);
        if(customerOpt.isPresent()) {
            Customer customer1 = customerOpt.get();
            return customer1.getSimId();
        }else {
            throw new CustomerIdNotFoundException("No customer found for given uniqueId");
        }
    }

    @Override
    public Customer getCustomerById(long uniqueId) {
        Optional<Customer> customerOpt = customerRepository.findById(uniqueId);
        if(customerOpt.isPresent()) {
            Customer customer1 = customerOpt.get();
            return customer1;
        }else {
            throw new CustomerIdNotFoundException("No customer found for given uniqueId");
        }
    }

}
