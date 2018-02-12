package com.acyl.jdbcsample.model;

import java.sql.Date;

import com.acyl.jdbcsample.model.Annotation.Column;
import com.acyl.jdbcsample.model.Annotation.PrimaryKey;
import com.acyl.jdbcsample.model.Annotation.Table;

@Table(name = "trip")
public class TripEntity {
    @PrimaryKey
    @Column(name = "trip_no")
    private Integer tripNo;
    @Column(name = "ID_comp")
    private Integer idComp;
    @Column(name = "plane", length = 10)
    private String plane;
    @Column(name = "town_from", length = 25)
    private String townFrom;
    @Column(name = "town_to", length = 25)
    private String townTo;
    @Column(name = "time_out")
    private Date timeOut;
    @Column(name = "time_in")
    private Date timeIn;

    public TripEntity() {
    }

    public TripEntity(Integer tripNo, Integer idComp, String plane, String townFrom, 
    		String townTo, Date timeOut, Date timeIn) {
		this.tripNo = tripNo;
		this.idComp = idComp;
		this.plane = plane;
		this.townFrom = townFrom;
		this.townTo = townTo;
		this.timeOut = timeOut;
		this.timeIn = timeIn;
	}


    public Integer getTripNo() {
		return tripNo;
	}

	public void setTripNo(Integer tripNo) {
		this.tripNo = tripNo;
	}

	public Integer getIdComp() {
		return idComp;
	}

	public void setIdComp(Integer idComp) {
		this.idComp = idComp;
	}

	public String getPlane() {
		return plane;
	}

	public void setPlane(String plane) {
		this.plane = plane;
	}

	public String getTownFrom() {
		return townFrom;
	}

	public void setTownFrom(String townFrom) {
		this.townFrom = townFrom;
	}

	public String getTownTo() {
		return townTo;
	}

	public void setTownTo(String townTo) {
		this.townTo = townTo;
	}

	public Date getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}

	public Date getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}

	@Override
    public String toString() {
        return String.format("%-5s %-15s %-15s %-25s %-25s %-25s %-25s", tripNo, idComp, plane, townFrom, townTo, timeOut.toString(), timeIn.toString());
    }
}
