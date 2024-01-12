package carmencaniglia.bes5l5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "buildings")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Building {
    @Id
    @GeneratedValue
    @Column(name = "building_id",nullable = false)
    private long id;
    private String name;
    private String address;
    private String city;


    public Building(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }
}
