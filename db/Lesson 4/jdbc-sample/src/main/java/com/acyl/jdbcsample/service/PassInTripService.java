package com.acyl.jdbcsample.service;

import com.acyl.jdbcsample.DAO.implementation.PassInTripDaoImpl;
import com.acyl.jdbcsample.model.PK_PassInTrip;
import com.acyl.jdbcsample.model.PassInTripEntity;

import java.sql.SQLException;
import java.util.List;

public class PassInTripService {
    public List<PassInTripEntity> findAll() throws SQLException {
        return new PassInTripDaoImpl().findAll();
    }


    public int create(PassInTripEntity entity) throws SQLException{
        return new PassInTripDaoImpl().create(entity);
    }

    public int update(PassInTripEntity entity) throws SQLException{
        return new PassInTripDaoImpl().update(entity);
    }

    public int delete(PK_PassInTrip pk) throws SQLException{
        return new PassInTripDaoImpl().delete(pk);
    }
}
