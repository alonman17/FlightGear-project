package com.flightgearserver.demo.Http.Flights;

import com.flightgearserver.demo.Http.Entiteis.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsRepository extends JpaRepository<Flight,Long> {
}
