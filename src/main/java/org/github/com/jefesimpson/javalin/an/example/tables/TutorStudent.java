package org.github.com.jefesimpson.javalin.an.example.tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Objects;

@DatabaseTable(tableName = "TutorStudent")
public class TutorStudent {
    @DatabaseField(id = true)
    private int id;
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Student student;
    @DatabaseField(foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Tutor tutor;

    public TutorStudent() {
    }

    public TutorStudent(int id, Student student, Tutor tutor) {
        this.id = id;
        this.student = student;
        this.tutor = tutor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TutorStudent that = (TutorStudent) o;
        return id == that.id &&
                Objects.equals(student, that.student) &&
                Objects.equals(tutor, that.tutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, tutor);
    }

    @Override
    public String toString() {
        return "TutorStudent{" +
                "id=" + id +
                ", student=" + student +
                ", tutor=" + tutor +
                '}';
    }
}
