package com.acyl.jdbcsample.model;

import java.sql.Date;

import com.acyl.jdbcsample.model.Annotation.Column;

public class PK_PassInTrip {
    @Column(name = "trip_no")
    private Integer tripNo;
    @Column(name = "date")
    private Date date;
    @Column(name = "ID_psg")
    private Integer idPsg;

    public PK_PassInTrip() {
    }

    public PK_PassInTrip(Integer tripNo, Date date, Integer idPsg) {
        this.tripNo = tripNo;
        this.date = date;
        this.idPsg = idPsg;
    }

    public Integer getTripNo() {
        return tripNo;
    }

    public void setTripNo(Integer tripNo) {
        this.tripNo = tripNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public Integer getIdPsg() {
    	return idPsg;
    }
    
    public void setIdPsg(Integer idPsg) {
    	this.idPsg = idPsg;
    }
}
