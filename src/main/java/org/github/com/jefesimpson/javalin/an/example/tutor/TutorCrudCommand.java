package org.github.com.jefesimpson.javalin.an.example.tutor;

import org.github.com.jefesimpson.javalin.an.example.student.Student;

import java.sql.SQLException;
import java.util.List;

public class TutorCrudCommand implements TutorConnection{

    @Override
    public List<Tutor> getTutor() throws SQLException {
        return dao().queryForAll();
    }

    @Override
    public Tutor getTutorById(int id) throws SQLException {
        return dao().queryForId(id);
    }

    @Override
    public void deleteTutor(int id) throws SQLException {
        dao().deleteById(id);
    }

    @Override
    public void postTutor(Tutor createTutor) throws SQLException {
        dao().create(createTutor);
    }

    @Override
    public void patchTutor(Tutor updateTutor) throws SQLException {
        dao().update(updateTutor);
    }
}
