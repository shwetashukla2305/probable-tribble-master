package com.glo.uservalidation.repository;

import com.glo.uservalidation.entity.Customer;
import com.glo.uservalidation.entity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {

}
