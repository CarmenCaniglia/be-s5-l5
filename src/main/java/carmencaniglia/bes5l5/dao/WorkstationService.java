package carmencaniglia.bes5l5.dao;

import carmencaniglia.bes5l5.entities.Building;
import carmencaniglia.bes5l5.entities.Workstation;
import carmencaniglia.bes5l5.entities.WorkstationType;
import carmencaniglia.bes5l5.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WorkstationService {
    @Autowired
    private WorkstationDAO workstationDAO;

    public void save(Workstation workstation){
        workstationDAO.save(workstation);
        log.info("Workstation correctly saved!");
    }

    public Workstation findById(long id){
        return workstationDAO.findById(id).orElseThrow(()-> new ItemNotFoundException(id));
    }

    public List<Workstation> findAll() {
        return workstationDAO.findAll();
    }

    public void delete(long id) {
        workstationDAO.deleteById(id);
        log.info("Workstation with id: " +id+ " successfully deleted!");
    }

    public void updateWorkstation(long id, String description, WorkstationType type, int peoples, Building building) {
        Workstation found = this.findById(id);
        if (found != null) {
            found.setDescription(description);
            found.setType(type);
            found.setPeoples(peoples);
            found.setBuilding(building);
            workstationDAO.save(found);
            log.info("Workstation with id " + id + " successfully updated!");
        } else {
            log.error("Workstation with id " + id + " not found!");
            throw new ItemNotFoundException(id);
        }
    }

    public void deleteWorkstation(long id) {
        workstationDAO.deleteById(id);
        log.info("Workstation with id: " + id + " successfully deleted!");
    }
}
