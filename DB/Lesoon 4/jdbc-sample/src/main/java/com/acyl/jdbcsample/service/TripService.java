package com.acyl.jdbcsample.service;

import com.acyl.jdbcsample.DAO.implementation.TripDaoImpl;
import com.acyl.jdbcsample.model.TripEntity;
import com.acyl.jdbcsample.persistant.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TripService {

    public List<TripEntity> findAll() throws SQLException {
        return new TripDaoImpl().findAll();
    }

    public TripEntity findById(Integer id) throws SQLException {
        return new TripDaoImpl().findById(id);
    }

    public int create(TripEntity entity) throws SQLException {
        return new TripDaoImpl().create(entity);
    }

    public int update(TripEntity entity) throws SQLException {
        return new TripDaoImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new TripDaoImpl().delete(id);
    }

}
