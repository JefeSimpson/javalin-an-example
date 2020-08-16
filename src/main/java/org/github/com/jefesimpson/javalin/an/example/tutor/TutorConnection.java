package org.github.com.jefesimpson.javalin.an.example.tutor;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import org.github.com.jefesimpson.javalin.an.example.connetion.DatabaseUtils;

import java.sql.SQLException;

public interface TutorConnection extends TutorCrud{
    default Dao<Tutor, Integer> dao() throws SQLException {
        return DaoManager.createDao(DatabaseUtils.connectionSource(), Tutor.class);
    }
}
