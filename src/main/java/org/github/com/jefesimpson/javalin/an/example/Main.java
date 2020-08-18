package org.github.com.jefesimpson.javalin.an.example;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.github.com.jefesimpson.javalin.an.example.command.Crud;
import org.github.com.jefesimpson.javalin.an.example.tables.StudentGroup;
import org.github.com.jefesimpson.javalin.an.example.tables.Student;
import org.github.com.jefesimpson.javalin.an.example.tables.Tutor;
import org.github.com.jefesimpson.javalin.an.example.tables.TutorStudent;

import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        javalinCommand(Javalin.create());
    }

    public static void javalinCommand(Javalin app){
        javalinStudentCommand(app);
        javalinGroupCommand(app);
        javalinTutorCommand(app);
        javalinTutorStudentCommand(app);
        app.start(9999);
    }


    public static void javalinStudentCommand(Javalin app){
        app.get("/students", context -> {
            context.result("Hello from Get ListAllStudent");

            Crud get = new Crud();

            context.result(get.getAllObject(Student.class).toString());
        });

        app.get("/student/:id", context -> {
            context.result("Hello from Get ListStudentById");

            Crud get = new Crud();

            context.result(get.getObject(Student.class ,Integer.parseInt(scannerParam(context,0))).toString());
        });

        app.post("/student", context -> {
            context.result("Hello from Post Create");

            Crud post = new Crud();

            StudentGroup studentGroup = (StudentGroup) post.getObject(StudentGroup.class ,Integer.parseInt(scannerParam(context, 3)));

            post.postObject(Student.class, new Student(Integer.parseInt(scannerParam(context, 0)),scannerParam(context, 1),scannerParam(context, 2), studentGroup));
        });

        app.patch("/student", context -> {
            context.result("Hello from Patch Update");

            Crud patch = new Crud();

            StudentGroup studentGroup = (StudentGroup) patch.getObject(StudentGroup.class ,Integer.parseInt(scannerParam(context,3)));

            patch.patchObject(Student.class, new Student(Integer.parseInt(scannerParam(context, 0)),scannerParam(context, 1),scannerParam(context, 2), studentGroup));
        });

        app.delete("/student/:id", context -> {
            context.result("Hello from Delete Delete");

            Crud delete = new Crud();

            delete.deleteObject(Student.class, Integer.parseInt(scannerParam(context, 0)));
        });
    }


    public static void javalinGroupCommand(Javalin app){
        app.get("/groups", context -> {
            context.result("Hello from Get ListAllGroup");

            Crud get = new Crud();

            context.result(get.getAllObject(StudentGroup.class).toString());
        });

        app.get("/group/:id", context -> {
            context.result("Hello from Get ListGroupById");

            Crud get = new Crud();

            context.result(get.getObject(StudentGroup.class, Integer.parseInt(scannerParam(context,0))).toString());
        });

        app.post("/group", context -> {
            context.result("Hello from Post Create");

            Crud post = new Crud();

            post.postObject(StudentGroup.class, new StudentGroup(Integer.parseInt(scannerParam(context,0)), scannerParam(context,1)));
        });

        app.patch("/group", context -> {
            context.result("Hello from Patch Update");

            Crud patch = new Crud();

            patch.patchObject(StudentGroup.class, new StudentGroup(Integer.parseInt(scannerParam(context,0)), scannerParam(context,1)));
        });

        app.delete("/group/:id", context -> {
            context.result("Hello from Delete Delete");

            Crud delete = new Crud();

            delete.deleteObject(StudentGroup.class, Integer.parseInt(scannerParam(context, 0)));
        });
    }


    public static void javalinTutorCommand(Javalin app){
        app.get("/tutors", context -> {
            context.result("Hello from Get ListAllTutor");

            Crud get = new Crud();

            context.result(get.getAllObject(Tutor.class).toString());
        });

        app.get("/tutor/:id", context -> {
            context.result("Hello from Get ListTutorById");

            Crud get = new Crud();

            context.result(get.getObject(Tutor.class, Integer.parseInt(scannerParam(context,0))).toString());
        });

        app.post("/tutor", context -> {
            context.result("Hello from Post Create");

            Crud post = new Crud();

            StudentGroup studentGroup = (StudentGroup) post.getObject(StudentGroup.class, Integer.parseInt(scannerParam(context, 3)));

            post.postObject(Tutor.class, new Tutor(Integer.parseInt(scannerParam(context, 0)),scannerParam(context, 1),scannerParam(context, 2), studentGroup));
        });

        app.patch("/tutor", context -> {
            context.result("Hello from Patch Update");

            Crud patch = new Crud();

            StudentGroup studentGroup = (StudentGroup) patch.getObject(StudentGroup.class, Integer.parseInt(scannerParam(context, 3)));

            patch.patchObject(Tutor.class, new Tutor(Integer.parseInt(scannerParam(context, 0)),scannerParam(context, 1),scannerParam(context, 2), studentGroup));
        });

        app.delete("/tutor/:id", context -> {
            context.result("Hello from Delete Delete");

            Crud delete = new Crud();

            delete.deleteObject(Tutor.class, Integer.parseInt(scannerParam(context, 0)));
        });
    }


    public static void javalinTutorStudentCommand(Javalin app){
        app.get("/tutorStudents", context -> {
            context.result("Hello from Get ListAllTutorStudent");

            Crud get = new Crud();

            context.result(get.getAllObject(TutorStudent.class).toString());
        });

        app.get("/tutorStudent/:id", context -> {
            context.result("Hello from Get ListTutorStudentById");

            Crud get = new Crud();

            context.result(get.getObject(TutorStudent.class, Integer.parseInt(scannerParam(context,0))).toString());
        });

        app.post("/tutorStudent", context -> {
            context.result("Hello from Post Create");

            Crud post = new Crud();

            Student student = (Student) post.getObject(Student.class, Integer.parseInt(scannerParam(context, 1)));
            Tutor tutor = (Tutor) post.getObject(Tutor.class, Integer.parseInt(scannerParam(context,2)));

            post.postObject(TutorStudent.class, new TutorStudent(Integer.parseInt(scannerParam(context,0)), student, tutor));
        });

        app.patch("/tutorStudent", context -> {
            context.result("Hello from Patch Update");

            Crud patch = new Crud();

            Student student = (Student) patch.getObject(Student.class, Integer.parseInt(scannerParam(context, 1)));
            Tutor tutor = (Tutor) patch.getObject(Tutor.class, Integer.parseInt(scannerParam(context,2)));

            patch.patchObject(TutorStudent.class, new TutorStudent(Integer.parseInt(scannerParam(context,0)), student, tutor));
        });

        app.delete("/tutorStudent/:id", context -> {
            context.result("Hello from Delete Delete");

            Crud delete = new Crud();

            delete.deleteObject(TutorStudent.class, Integer.parseInt(scannerParam(context, 0)));
        });
    }


    public static String stringParam(Context context, int i){
        Collection<String> strings = context.pathParamMap().values();
        String[] array = strings.toArray(String[]::new);
        return array[i];
    }

    public static String scannerParam(Context context, int i){
        Scanner scanner = new Scanner(context.body());
        Stream<String> strings = scanner.tokens();
        String[] array = strings.toArray(String[]::new);
        return array[i];
    }

}
