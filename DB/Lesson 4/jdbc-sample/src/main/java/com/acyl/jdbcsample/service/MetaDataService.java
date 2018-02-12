package com.acyl.jdbcsample.service;

import com.acyl.jdbcsample.DAO.implementation.MetaDataDaoImpl;
import com.acyl.jdbcsample.model.metadata.TableMetaData;

import java.sql.SQLException;
import java.util.List;

public class MetaDataService {
    public List<String> findAllTableName() throws SQLException {
        return new MetaDataDaoImpl().findAllTableName();
    }

    public List<TableMetaData> getTablesStructure() throws SQLException {
        return new MetaDataDaoImpl().getTablesStructure();
    }

}
