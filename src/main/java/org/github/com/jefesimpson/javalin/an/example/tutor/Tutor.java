package org.github.com.jefesimpson.javalin.an.example.tutor;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.github.com.jefesimpson.javalin.an.example.group.StudentGroup;

import java.util.Objects;

@DatabaseTable(tableName = "Tutor")
public class Tutor {
    @DatabaseField(id = true)
    private int id;
    @DatabaseField(columnName = "first_name")
    private String firstName;
    @DatabaseField(columnName = "last_name")
    private String lastName;
    @DatabaseField(foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private StudentGroup studentGroup;


    public Tutor() {
    }


    public Tutor(int id, String firstName, String lastName, StudentGroup studentGroup) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentGroup = studentGroup;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutor tutor = (Tutor) o;
        return id == tutor.id &&
                Objects.equals(firstName, tutor.firstName) &&
                Objects.equals(lastName, tutor.lastName) &&
                Objects.equals(studentGroup, tutor.studentGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, studentGroup);
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentGroup=" + studentGroup +
                '}';
    }
}
