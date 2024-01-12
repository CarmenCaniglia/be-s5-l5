package carmencaniglia.bes5l5.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Workstations")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Workstation {
    @Id
    @GeneratedValue
    private long id;
    private String description;
    private WorkstationType type;
    private int peoples;
    private Building building;
}
