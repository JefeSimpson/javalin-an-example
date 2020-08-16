package org.github.com.jefesimpson.javalin.an.example.student;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.github.com.jefesimpson.javalin.an.example.group.StudentGroup;

import java.util.Objects;

@DatabaseTable(tableName = "Student")
public class Student {
    @DatabaseField(id = true)
    private int id;
    @DatabaseField(columnName = "first_name")
    private String firstName;
    @DatabaseField(columnName = "last_name")
    private String lastName;
    @DatabaseField(columnName = "group_id", foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private StudentGroup studentGroup;

    public Student(int id, String firstName, String lastName, StudentGroup studentGroup) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentGroup = studentGroup;
    }
    public Student() {

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
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentGroup=" + studentGroup +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(studentGroup, student.studentGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, studentGroup);
    }
}
