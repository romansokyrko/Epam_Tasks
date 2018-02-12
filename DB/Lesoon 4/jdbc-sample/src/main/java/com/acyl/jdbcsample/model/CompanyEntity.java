package com.acyl.jdbcsample.model;

import com.acyl.jdbcsample.model.Annotation.Column;
import com.acyl.jdbcsample.model.Annotation.PrimaryKey;
import com.acyl.jdbcsample.model.Annotation.Table;

@Table(name = "company")
public class CompanyEntity {
    @PrimaryKey
    @Column(name = "ID_comp")
    private Integer idComp;
    @Column(name = "name", length = 10)
    private String name;

    public CompanyEntity() {
    }

    public CompanyEntity(Integer idComp, String name) {
        this.idComp = idComp;
        this.name = name;
    }

    public Integer getIdComp() {
        return idComp;
    }

    public void setIdComp(Integer idComp) {
        this.idComp = idComp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-15s", idComp, name);
    }
}
