package com.acyl.jdbcsample.model;

import com.acyl.jdbcsample.model.Annotation.Column;
import com.acyl.jdbcsample.model.Annotation.PrimaryKeyComposite;
import com.acyl.jdbcsample.model.Annotation.Table;

@Table(name = "pass_in_trip")
public class PassInTripEntity {
    @PrimaryKeyComposite
    private PK_PassInTrip pk;
    @Column(name = "place", length = 10)
    private String place;


    public PassInTripEntity() {
    }

    public PassInTripEntity(PK_PassInTrip pk, String place) {
        this.pk = pk;
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }


    public PK_PassInTrip getPk() {
        return pk;
    }

    public void setPk(PK_PassInTrip pk) {
        this.pk = pk;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-11s %-15s %s", pk.getTripNo(), pk.getDate().toString(), pk.getIdPsg(), getPlace());
    }
}
