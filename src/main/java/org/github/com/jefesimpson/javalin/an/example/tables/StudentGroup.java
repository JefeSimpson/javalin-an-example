package org.github.com.jefesimpson.javalin.an.example.tables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Objects;

@DatabaseTable(tableName ="StudentGroup")
public class StudentGroup {
    @DatabaseField(id = true)
    private int id;
    @DatabaseField(columnName = "group_name")
    private String groupName;

    public StudentGroup() {

    }

    public StudentGroup(int id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroup that = (StudentGroup) o;
        return id == that.id &&
                Objects.equals(groupName, that.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupName);
    }
}
