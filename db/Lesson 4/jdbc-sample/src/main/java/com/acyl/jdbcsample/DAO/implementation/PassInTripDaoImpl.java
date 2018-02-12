package com.acyl.jdbcsample.DAO.implementation;

import com.acyl.jdbcsample.DAO.PassInTripDAO;
import com.acyl.jdbcsample.model.PK_PassInTrip;
import com.acyl.jdbcsample.model.PassInTripEntity;
import com.acyl.jdbcsample.persistant.ConnectionManager;
import com.acyl.jdbcsample.transformer.Transformer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassInTripDaoImpl implements PassInTripDAO {
    private static final String FIND_ALL = "SELECT * FROM pass_in_trip";
    private static final String DELETE = "DELETE FROM pass_in_trip WHERE trip_no=? AND date=? AND ID_psg=?";
    private static final String CREATE = "INSERT pass_in_trip (trip_no, date, ID_psg, place) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE pass_in_trip SET place=? WHERE etrip_no=? AND date=? AND ID_psg=?";

    @Override
    public List<PassInTripEntity> findAll() throws SQLException {
        List<PassInTripEntity> passes = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                	passes.add((PassInTripEntity) new Transformer(PassInTripEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return passes;
    }

    @Override
    public PassInTripEntity findById(PK_PassInTrip pk_passInTrip) throws SQLException {
        return null;
    }

    @Override
    public int create(PassInTripEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,entity.getPk().getTripNo());
            ps.setDate(2,entity.getPk().getDate());
            ps.setInt(3,entity.getPk().getIdPsg());
            ps.setString(4,entity.getPlace());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(PassInTripEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setInt(1,entity.getPk().getTripNo());
            ps.setDate(2,entity.getPk().getDate());
            ps.setInt(3,entity.getPk().getIdPsg());
            ps.setString(4,entity.getPlace());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(PK_PassInTrip id) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1,id.getTripNo());
            ps.setDate(2,id.getDate());
            ps.setInt(3,id.getIdPsg());
            return ps.executeUpdate();
        }
    }
}
