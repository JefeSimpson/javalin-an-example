package org.github.com.jefesimpson.javalin.an.example.command;

import java.sql.SQLException;
import java.util.List;

public class Crud <T> implements CrudConnection {
    public List<T> getAllObject(Class crudClass) throws SQLException {
        return dao(crudClass).queryForAll();
    }

    public T getObject(Class crudClass, int id) throws SQLException {
        return (T) dao(crudClass).queryForId(id);
    }

    public void postObject(Class crudClass, T t) throws SQLException {
        dao(crudClass).create(t);
    }

    public void patchObject(Class crudClass, T t) throws SQLException {
        dao(crudClass).update(t);
    }

    public void deleteObject(Class crudClass, int id) throws SQLException {
        dao(crudClass).deleteById(id);
    }
}
