package com.acyl.jdbcsample.DAO.implementation;

import com.acyl.jdbcsample.DAO.TripDAO;
import com.acyl.jdbcsample.model.TripEntity;
import com.acyl.jdbcsample.persistant.ConnectionManager;
import com.acyl.jdbcsample.transformer.Transformer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TripDaoImpl implements TripDAO {
    private static final String FIND_ALL = "SELECT * FROM trip";
    private static final String DELETE = "DELETE FROM trip WHERE trip_no=?";
    private static final String CREATE = "INSERT trip (trip_no, ID_comp, plane, town_from, town_to, time_out, time_in) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE trip SET ID_comp=?, plane=?, town_from=?, town_to=?, time_out=?, time_in=? WHERE trip_no=?";
    private static final String FIND_BY_ID = "SELECT * FROM trip WHERE trip_no=?";



    @Override
    public List<TripEntity> findAll() throws SQLException {
        List<TripEntity> trips = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                	trips.add((TripEntity)new Transformer(TripEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return trips;
    }

    @Override
    public TripEntity findById(Integer id) throws SQLException {
    	TripEntity entity=null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1,id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity=(TripEntity)new Transformer(TripEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(TripEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,entity.getTripNo());
            ps.setInt(2,entity.getIdComp());
            ps.setString(3,entity.getPlane());
            ps.setString(4,entity.getTownFrom());
            ps.setString(5,entity.getTownTo());
            ps.setDate(6,entity.getTimeOut());
            ps.setDate(7,entity.getTimeIn());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(TripEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setInt(1,entity.getTripNo());
            ps.setInt(2,entity.getIdComp());
            ps.setString(3,entity.getPlane());
            ps.setString(4,entity.getTownFrom());
            ps.setString(5,entity.getTownTo());
            ps.setDate(6,entity.getTimeOut());
            ps.setDate(7,entity.getTimeIn());
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
