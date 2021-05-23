package pl.edu.pwr.ztw.SportsHallReservationAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="hall_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "sportHalls"})
public class HallType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="type_id")
    private int typeId;


    @Column(name="type")
    private String type;

    @OneToMany(mappedBy = "hallType")
    private List<SportHall> sportHalls;

    public HallType() {
        super();
    }

    public HallType(int typeId, String type, List<SportHall> sportHalls) {
        super();
        this.typeId = typeId;
        this.type = type;
        this.sportHalls = sportHalls;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<SportHall> getSportHalls() {
        return sportHalls;
    }

    public void setSportHalls(List<SportHall> sportHalls) {
        this.sportHalls = sportHalls;
    }
}
