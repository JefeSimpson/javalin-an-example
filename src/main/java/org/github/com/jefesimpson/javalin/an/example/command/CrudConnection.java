package org.github.com.jefesimpson.javalin.an.example.command;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import org.github.com.jefesimpson.javalin.an.example.connetion.DatabaseUtils;

import java.sql.SQLException;

public interface CrudConnection <T>{
    default Dao<T, Integer> dao(Class crudClass) throws SQLException {
        return DaoManager.createDao(DatabaseUtils.connectionSource(), crudClass);
    }
}
