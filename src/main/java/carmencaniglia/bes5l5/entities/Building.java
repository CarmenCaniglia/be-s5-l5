package carmencaniglia.bes5l5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "buildings")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Building {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String address;
    private String city;
}
