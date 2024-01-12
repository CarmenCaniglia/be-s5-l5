package carmencaniglia.bes5l5.dao;

import carmencaniglia.bes5l5.entities.Workstation;
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

    public void updateWorkstation(long id, Workstation workstation) {
        Workstation found = this.findById(id);
        found.setDescription(workstation.getDescription());
        found.setType(workstation.getType());
        found.setPeoples(workstation.getPeoples());
        found.setBuilding(workstation.getBuilding());
        workstationDAO.save(found);
        log.info("Workstation with id " + id + " successfully updated!");
    }
}
