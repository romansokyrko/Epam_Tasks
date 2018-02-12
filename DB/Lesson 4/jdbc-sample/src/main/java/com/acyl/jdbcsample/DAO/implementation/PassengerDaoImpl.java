package com.acyl.jdbcsample.DAO.implementation;

import com.acyl.jdbcsample.DAO.PassengerDAO;
import com.acyl.jdbcsample.model.PassengerEntity;
import com.acyl.jdbcsample.persistant.ConnectionManager;
import com.acyl.jdbcsample.transformer.Transformer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerDaoImpl implements PassengerDAO {
    private static final String FIND_ALL = "SELECT * FROM passenger";
    private static final String DELETE = "DELETE FROM passenger WHERE ID_psg=?";
    private static final String CREATE = "INSERT passenger (ID_psg, name) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE passenger SET name=? WHERE ID_psg=?";
    private static final String FIND_BY_ID = "SELECT * FROM passenger WHERE ID_psg=?";



    @Override
    public List<PassengerEntity> findAll() throws SQLException {
        List<PassengerEntity> passengers = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                	passengers.add((PassengerEntity)new Transformer(PassengerEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return passengers;
    }

    @Override
    public PassengerEntity findById(Integer id) throws SQLException {
    	PassengerEntity entity=null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1,id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity=(PassengerEntity)new Transformer(PassengerEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(PassengerEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,entity.getIdPsg());
            ps.setString(2,entity.getName());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(PassengerEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setInt(1,entity.getIdPsg());
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
