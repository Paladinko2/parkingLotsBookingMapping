package com.Utis;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "TimePeriod", nullable = false)
    private Integer timePeriod;

    @Column(name = "BookingDate", nullable = false)
    private LocalDate bookingDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IdDriver", nullable = false)
    private Driver idDriver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdLot")
    private Parkinglot idLot;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(Integer timePeriod) {
        this.timePeriod = timePeriod;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Driver getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Driver idDriver) {
        this.idDriver = idDriver;
    }

    public Parkinglot getIdLot() {
        return idLot;
    }

    public void setIdLot(Parkinglot idLot) {
        this.idLot = idLot;
    }

    @Override
    public String toString() {
        return "\n{Id}: " + this.getId() + "\n{TimePeriod}: " + this.getTimePeriod() + "\n{BookingDate}: " + this.getBookingDate() + "\n{IdDriver}: " + this.getIdDriver().getId() + "\n{IdLot}: " + this.getIdLot().getId();
    }

}