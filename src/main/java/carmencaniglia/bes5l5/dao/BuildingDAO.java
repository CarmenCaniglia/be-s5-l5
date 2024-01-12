package carmencaniglia.bes5l5.dao;

import carmencaniglia.bes5l5.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingDAO extends JpaRepository<Building,Long> {
    List<Building> findByCity(String city);
    //--> sono da implementare nel service per testarle
}
