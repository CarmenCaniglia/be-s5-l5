package carmencaniglia.bes5l5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    private long id;
    private User user;
    private Workstation workstation;
    private LocalDate date;

    //momentanea, probabilmente da modificare
}
