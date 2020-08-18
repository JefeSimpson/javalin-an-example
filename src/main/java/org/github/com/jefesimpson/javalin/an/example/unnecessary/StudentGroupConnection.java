package org.github.com.jefesimpson.javalin.an.example.unnecessary;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import org.github.com.jefesimpson.javalin.an.example.connetion.DatabaseUtils;
import org.github.com.jefesimpson.javalin.an.example.tables.StudentGroup;

import java.sql.SQLException;

public interface StudentGroupConnection extends StudentGroupCrud {
    default Dao<StudentGroup, Integer> dao() throws SQLException{
        return DaoManager.createDao(DatabaseUtils.connectionSource(), StudentGroup.class);
    }
}
