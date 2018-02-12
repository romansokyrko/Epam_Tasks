package com.acyl.jdbcsample.model;

import com.acyl.jdbcsample.model.Annotation.Column;
import com.acyl.jdbcsample.model.Annotation.PrimaryKey;
import com.acyl.jdbcsample.model.Annotation.Table;

@Table(name = "passenger")
public class PassengerEntity {
	@PrimaryKey
	@Column(name = "ID_psg")
	private Integer idPsg;
	@Column(name = "name", length = 20)
	private String name;

	public PassengerEntity() {
	    }

	public PassengerEntity(Integer idPsg, String name) {
	        this.idPsg = idPsg;
	        this.name = name;
	    }

	public Integer getIdPsg() {
		return idPsg;
	}

	public void setIdPsg(Integer idPsg) {
		this.idPsg = idPsg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%-5s %-15s", idPsg, name);
	}
}
