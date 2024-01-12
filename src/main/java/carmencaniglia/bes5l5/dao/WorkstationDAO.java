package carmencaniglia.bes5l5.dao;

import carmencaniglia.bes5l5.entities.Workstation;
import carmencaniglia.bes5l5.entities.WorkstationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkstationDAO extends JpaRepository<Workstation, Long> {
    List<Workstation> findByType(WorkstationType type);
    List<Workstation> findByBuildingId(Long buildingId);

    //--> sono da implementare nel service per testarle
}
