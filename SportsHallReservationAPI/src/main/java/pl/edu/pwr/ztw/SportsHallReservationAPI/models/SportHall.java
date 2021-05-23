package pl.edu.pwr.ztw.SportsHallReservationAPI.models;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name="sport_hall")
public class SportHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hall_id")
    private int id;

    @ManyToOne
    @JoinColumn(name="type")
    private HallType hallType;

    @Column(name="work_from")
    private Time work_from;

    @Column(name="work_to")
    private Time work_to;

    @Column(name="price_one_hour")
    private double price_one_hour;

    @Column(name="capacity")
    private Integer capacity;

    @Column(name="nr_hall")
    private int nr_hall;

    public SportHall()
    {
        super();
    }


    public SportHall(int id, HallType hallType, Time work_from, Time work_to, double price_one_hour, Integer capacity, int nr_hall) {
        super();
        this.id = id;
        this.hallType = hallType;
        this.work_from = work_from;
        this.work_to = work_to;
        this.price_one_hour = price_one_hour;
        this.capacity = capacity;
        this.nr_hall = nr_hall;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getWork_from() {
        return work_from;
    }

    public void setWork_from(Time work_from) {
        this.work_from = work_from;
    }

    public HallType getHallType() {
        return hallType;
    }

    public void setHallType(HallType hallType) {
        this.hallType = hallType;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Time getWork_to() {
        return work_to;
    }

    public void setWork_to(Time work_to) {
        this.work_to = work_to;
    }

    public double getPrice_one_hour() {
        return price_one_hour;
    }

    public void setPrice_one_hour(double price_one_hour) {
        this.price_one_hour = price_one_hour;
    }





    public int getNr_hall() {
        return nr_hall;
    }

    public void setNr_hall(int nr_hall) {
        this.nr_hall = nr_hall;
    }
}
