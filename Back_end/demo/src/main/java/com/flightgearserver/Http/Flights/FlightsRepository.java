package com.flightgearserver.Http.Flights;

import com.flightgearserver.Http.Entiteis.Flight;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightsRepository extends JpaRepository<Flight,Long> {

    @Override
    @Cacheable("flights")
    List<Flight> findAll();

    @Override
    @CacheEvict(value = "flights", allEntries = true)
    Flight save(Flight flight);
}
