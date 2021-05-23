package pl.edu.pwr.ztw.SportsHallReservationAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="reservation")
/*@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "user", "sportHall"})*/
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reservation_id")
    private int id;

    @ManyToOne
    @JoinColumn(name="id_user", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="id_hall", referencedColumnName = "hall_id")
    private SportHall sportHall;

    @Column(name="reservation_date")
    private Date reservationDate;

    @Column(name="time_from")
    private Time timeFrom;

    @Column(name="time_to")
    private Time timeTo;

    @Column(name="full_price")
    private double fullPrice;

    @Column(name="is_paid")
    private boolean isPaid;

    @Column(name="description")
    private String description;


    public Reservation() {
        super();
    }

    public Reservation(int id, User user, SportHall sportHall, Date reservationDate, Time timeFrom,
                       Time timeTo, double fullPrice, boolean isPaid, String description) {
        super();
        this.id = id;
        this.user = user;
        this.sportHall = sportHall;
        this.reservationDate = reservationDate;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.fullPrice = fullPrice;
        this.isPaid = isPaid;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SportHall getSportHall() {
        return sportHall;
    }

    public void setSportHall(SportHall sportHall) {
        this.sportHall = sportHall;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Time getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Time timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Time getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Time timeTo) {
        this.timeTo = timeTo;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String isDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
