package com.glo.uservalidation.repository;

import com.glo.uservalidation.entity.Customer;
import com.glo.uservalidation.entity.CustomerIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerIdentityRepository extends JpaRepository<CustomerIdentity, Long> {
}
