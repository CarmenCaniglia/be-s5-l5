package carmencaniglia.bes5l5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    @Column(name = "reservation_id", nullable = false)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "workstation_id")
    private Workstation workstation;
    private LocalDate date;

    //momentanea, probabilmente da modificare


    public Reservation(User user, Workstation workstation, LocalDate date) {
        this.user = user;
        this.workstation = workstation;
        this.date = date;
    }
}
