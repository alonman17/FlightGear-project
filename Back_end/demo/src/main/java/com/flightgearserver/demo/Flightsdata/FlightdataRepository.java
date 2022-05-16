package com.flightgearserver.demo.Flightsdata;

import com.flightgearserver.demo.Entiteis.Flightsdatum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightdataRepository extends JpaRepository<Flightsdatum,Long> {
}
