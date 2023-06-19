package com.glo.uservalidation.repository;

import com.glo.uservalidation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmailAddress(String emailAddress);
    Customer findByFirstNameAndLastName(String firstName, String lastName);
}
