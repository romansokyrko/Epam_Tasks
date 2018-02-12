package com.acyl.jdbcsample.service;

import com.acyl.jdbcsample.DAO.implementation.PassengerDaoImpl;
import com.acyl.jdbcsample.model.PassengerEntity;
import com.acyl.jdbcsample.persistant.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PassengerService {

    public List<PassengerEntity> findAll() throws SQLException {
        return new PassengerDaoImpl().findAll();
    }

    public PassengerEntity findById(Integer id) throws SQLException {
        return new PassengerDaoImpl().findById(id);
    }

    public int create(PassengerEntity entity) throws SQLException {
        return new PassengerDaoImpl().create(entity);
    }

    public int update(PassengerEntity entity) throws SQLException {
        return new PassengerDaoImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new PassengerDaoImpl().delete(id);
    }

}
