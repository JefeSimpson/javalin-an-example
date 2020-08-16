package org.github.com.jefesimpson.javalin.an.example.tutorstudent;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import org.github.com.jefesimpson.javalin.an.example.connetion.DatabaseUtils;

import java.sql.SQLException;

public interface TutorStudentConnection extends TutorStudentCrud{
    default Dao<TutorStudent, Integer> dao() throws SQLException {
        return DaoManager.createDao(DatabaseUtils.connectionSource(), TutorStudent.class);
    }
}
