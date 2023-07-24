package repository;

import model.Appointments;
import model.FirstLevelDivisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstLevelDivisionsRepository extends JpaRepository<FirstLevelDivisions, Integer> {
}
