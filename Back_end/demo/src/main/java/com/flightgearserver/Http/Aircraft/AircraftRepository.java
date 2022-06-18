package com.flightgearserver.Http.Aircraft;

import com.flightgearserver.Http.Entiteis.Aircraft;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft,Long> {
        @Override
        @Cacheable("aircrafts")
        List<Aircraft> findAll();

        @Override
        @CacheEvict(value = "aircrafts", allEntries = true)
        Aircraft save(Aircraft aircraft);

}
