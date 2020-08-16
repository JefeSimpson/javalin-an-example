package org.github.com.jefesimpson.javalin.an.example.tutorstudent;

import java.sql.SQLException;
import java.util.List;

public class TutorStudentCrudCommand implements TutorStudentConnection{

    @Override
    public List<TutorStudent> getTutorStudent() throws SQLException {
        return dao().queryForAll();
    }

    @Override
    public TutorStudent getTutorStudentById(int id) throws SQLException {
        return dao().queryForId(id);
    }

    @Override
    public void deleteTutorStudent(int id) throws SQLException {
        dao().deleteById(id);
    }

    @Override
    public void postTutorStudent(TutorStudent createTutorStudent) throws SQLException {
        dao().create(createTutorStudent);
    }

    @Override
    public void patchTutorStudent(TutorStudent updateTutorStudent) throws SQLException {
        dao().update(updateTutorStudent);
    }
}
