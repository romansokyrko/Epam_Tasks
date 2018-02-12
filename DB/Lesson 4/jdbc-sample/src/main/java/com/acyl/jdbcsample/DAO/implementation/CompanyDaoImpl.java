package com.acyl.jdbcsample.DAO.implementation;

import com.acyl.jdbcsample.DAO.CompanyDAO;
import com.acyl.jdbcsample.model.CompanyEntity;
import com.acyl.jdbcsample.persistant.ConnectionManager;
import com.acyl.jdbcsample.transformer.Transformer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDaoImpl implements CompanyDAO {
    private static final String FIND_ALL = "SELECT * FROM company";
    private static final String DELETE = "DELETE FROM company WHERE ID_comp=?";
    private static final String CREATE = "INSERT company (ID_comp, name) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE company SET name=? WHERE ID_comp=?";
    private static final String FIND_BY_ID = "SELECT * FROM company WHERE ID_comp=?";



    @Override
    public List<CompanyEntity> findAll() throws SQLException {
        List<CompanyEntity> companies = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                	companies.add((CompanyEntity)new Transformer(CompanyEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return companies;
    }

    @Override
    public CompanyEntity findById(Integer id) throws SQLException {
    	CompanyEntity entity=null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1,id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity=(CompanyEntity)new Transformer(CompanyEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(CompanyEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,entity.getIdComp());
            ps.setString(2,entity.getName());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(CompanyEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setInt(1,entity.getIdComp());
            ps.setString(2,entity.getName());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1,id);
            return ps.executeUpdate();
        }
    }

}
