package com.Utis;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Price", nullable = false)
    private Integer price;

    @Lob
    @Column(name = "PaymentStatus")
    private String paymentStatus;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IdReservation", nullable = false)
    private Reservation idReservation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Reservation getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Reservation idReservation) {
        this.idReservation = idReservation;
    }

    @Override
    public String toString() {
        return "\n{Id}: " + this.getId() + "\n{Price}: " + this.getPrice() + "\n{Status}: " + this.getPaymentStatus() + "\n{IdReservation}: " + this.getIdReservation().getId();
    }

}