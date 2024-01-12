package carmencaniglia.bes5l5.dao;

import carmencaniglia.bes5l5.entities.Reservation;
import carmencaniglia.bes5l5.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class ReservationService {
    @Autowired
    private ReservationDAO reservationDAO;

    public void saveReservation(Reservation reservation) {
        reservationDAO.save(reservation);
        log.info("Reservation correctly saved!");
    }

    public Reservation findById(long id) {
        return reservationDAO.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    public List<Reservation> findAll() {
        return reservationDAO.findAll();
    }

    public void updateReservation(long id, Reservation reservationDetails) {
        Reservation found = this.findById(id);
        // Assicurati di aggiornare tutti i campi rilevanti
        found.setUser(reservationDetails.getUser());
        found.setWorkstation(reservationDetails.getWorkstation());
        found.setDate(reservationDetails.getDate());
        reservationDAO.save(found);
        log.info("Reservation with id " + id + " successfully updated!");
    }

    public void deleteReservation(long id) {
        reservationDAO.deleteById(id);
        log.info("Reservation with id: " + id + " successfully deleted!");
    }
}
