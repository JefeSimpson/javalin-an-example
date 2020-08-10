package org.github.com.jefesimpson.javalin.an.example;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import org.github.com.jefesimpson.javalin.an.example.DatabaseUtils;

import java.sql.SQLException;

public interface StudentConnection extends StudentCrud {
    default Dao<Student, Integer> dao() throws SQLException{
        return DaoManager.createDao(DatabaseUtils.connectionSource(), Student.class);
    }
}
