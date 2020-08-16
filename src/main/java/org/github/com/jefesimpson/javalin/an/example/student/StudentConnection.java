package org.github.com.jefesimpson.javalin.an.example.student;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import org.github.com.jefesimpson.javalin.an.example.connetion.DatabaseUtils;

import java.sql.SQLException;

public interface StudentConnection extends StudentCrud {
    default Dao<Student, Integer> dao() throws SQLException{
        return DaoManager.createDao(DatabaseUtils.connectionSource(), Student.class);
    }
}
