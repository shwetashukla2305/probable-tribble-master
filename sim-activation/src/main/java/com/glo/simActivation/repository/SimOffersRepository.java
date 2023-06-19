package com.glo.simActivation.repository;

import com.glo.simActivation.entity.SimDetails;
import com.glo.simActivation.entity.SimOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SimOffersRepository extends JpaRepository<SimOffers, Integer> {

    @Query(value = "select * from sim_offers where sim_details_sim_id = ?1", nativeQuery = true)
    SimOffers findOffersBySimId(int simId);
}
