package com.Utis;

import javax.persistence.*;

@Entity
@Table(name = "auto")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Mark", nullable = false, length = 20)
    private String mark;

    @Column(name = "PlateNumber", nullable = false, length = 20)
    private String plateNumber;

    @Column(name = "Color", nullable = false, length = 20)
    private String color;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IdDriver", nullable = false)
    private Driver idDriver;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Driver getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Driver idDriver) {
        this.idDriver = idDriver;
    }

    @Override
    public String toString() {
        return "\n{Id}: " + this.getId() + "\n{Mark}: " + this.getMark() + "\n{PlaneNumber}: " + this.getPlateNumber() + "\n{IdDriver}: " + this.getIdDriver().getId() + "\n{Color}: " + this.getColor();
    }

}
