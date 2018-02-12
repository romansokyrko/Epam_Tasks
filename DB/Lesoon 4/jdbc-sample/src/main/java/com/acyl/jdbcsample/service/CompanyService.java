package com.acyl.jdbcsample.service;

import com.acyl.jdbcsample.DAO.implementation.CompanyDaoImpl;
import com.acyl.jdbcsample.model.CompanyEntity;

import com.acyl.jdbcsample.persistant.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CompanyService {

    public List<CompanyEntity> findAll() throws SQLException {
        return new CompanyDaoImpl().findAll();
    }

    public CompanyEntity findById(Integer id) throws SQLException {
        return new CompanyDaoImpl().findById(id);
    }

    public int create(CompanyEntity entity) throws SQLException {
        return new CompanyDaoImpl().create(entity);
    }

    public int update(CompanyEntity entity) throws SQLException {
        return new CompanyDaoImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new CompanyDaoImpl().delete(id);
    }

}
