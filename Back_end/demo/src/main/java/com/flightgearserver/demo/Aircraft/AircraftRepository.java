package com.flightgearserver.demo.Aircraft;

import com.flightgearserver.demo.Entiteis.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AircraftRepository extends JpaRepository<Aircraft,Long>{
}
