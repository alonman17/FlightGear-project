package flightgearserver.Http.Aircraft;

import flightgearserver.Http.Entiteis.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft,Long> {

}
