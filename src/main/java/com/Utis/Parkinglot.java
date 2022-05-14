package com.Utis;

import javax.persistence.*;

@Entity
@Table(name = "parkinglot")
public class Parkinglot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "LotNumber", nullable = false, length = 15)
    private String lotNumber;

    @Lob
    @Column(name = "LotStatus", nullable = false)
    private String lotStatus;

    @Lob
    @Column(name = "LotType", nullable = false)
    private String lotType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getLotStatus() {
        return lotStatus;
    }

    public void setLotStatus(String lotStatus) {
        this.lotStatus = lotStatus;
    }

    public String getLotType() {
        return lotType;
    }

    public void setLotType(String lotType) {
        this.lotType = lotType;
    }

}