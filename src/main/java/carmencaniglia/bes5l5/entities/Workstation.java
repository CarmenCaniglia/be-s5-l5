package carmencaniglia.bes5l5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Workstations")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Workstation {
    @Id
    @GeneratedValue
    @Column(name = "workstation_id",nullable = false)
    private long id;
    private String description;
    @Enumerated(EnumType.STRING)
    private WorkstationType type;
    private int peoples;
    @ManyToOne(optional = false)
    @JoinColumn(name = "building_id")
    private Building building;

    public Workstation(String description, WorkstationType type, int peoples, Building building) {
        this.description = description;
        this.type = type;
        this.peoples = peoples;
        this.building = building;
    }
}
