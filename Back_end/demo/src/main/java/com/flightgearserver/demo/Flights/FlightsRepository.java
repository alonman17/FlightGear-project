package com.flightgearserver.demo.Flights;

import com.flightgearserver.demo.Entiteis.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsRepository extends JpaRepository<Flight,Long> {
}
