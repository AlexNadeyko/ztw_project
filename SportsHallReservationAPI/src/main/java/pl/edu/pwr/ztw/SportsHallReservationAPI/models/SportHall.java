package pl.edu.pwr.ztw.SportsHallReservationAPI.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sporthalls")
public class SportHall {

    @Id
    @GeneratedValue
    private int id;

    private String type;

    public SportHall()
    {
        super();
    }

    public SportHall(int id, String type) {
        super();
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
