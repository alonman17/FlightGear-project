package com.flightgearserver.demo.Http.Flightsdata;

import com.flightgearserver.demo.Http.Entiteis.Flightsdatum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightdataRepository extends JpaRepository<Flightsdatum,Long> {
    @Query(value = "SELECT a from Flightsdatum as a  where a.flightid=?1")
    List<Flightsdatum> findAllFlightData(Long id);
}
