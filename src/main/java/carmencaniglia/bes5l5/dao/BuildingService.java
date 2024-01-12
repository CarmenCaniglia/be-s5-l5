package carmencaniglia.bes5l5.dao;

import carmencaniglia.bes5l5.entities.Building;
import carmencaniglia.bes5l5.entities.User;
import carmencaniglia.bes5l5.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BuildingService {
    @Autowired
    private BuildingDAO buildingDAO;

    public void save(Building building){
        buildingDAO.save(building);
        log.info("Building correctly saved!");
    }

    public Building findById(long id){
        return buildingDAO.findById(id).orElseThrow(()->new ItemNotFoundException(id));
    }

    public List<Building> findAll(){
        return buildingDAO.findAll();
    }

    public void updateBuilding(long id, Building building) {
        Building found = this.findById(id);
        found.setName(building.getName());
        found.setAddress(building.getAddress());
        found.setCity(building.getCity());
        buildingDAO.save(found);
        log.info("Building with id " + id + " successfully updated!");
    }
    public void delete(long id){
        buildingDAO.deleteById(id);
        log.info("Building with id: " +id+ " successfully deleted!");
    }
}
