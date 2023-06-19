package com.glo.simActivation.repository;

import com.glo.simActivation.entity.SimDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface SimDetailsRepository extends JpaRepository<SimDetails, Integer> {

    SimDetails findByServiceNumberAndSimNumber(long serviceNumber, long simNumber);

    @Modifying
    @Transactional
    @Query(value = "update sim_details set sim_status = 'ACTIVE' where sim_id= ?1", nativeQuery = true)
    Integer updateSIMStatus(int simId);
}
