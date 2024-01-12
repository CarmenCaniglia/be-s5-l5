package carmencaniglia.bes5l5.dao;

import carmencaniglia.bes5l5.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkstationDAO extends JpaRepository<Workstation, Long> {
}
