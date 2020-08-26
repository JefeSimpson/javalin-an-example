package org.github.com.jefesimpson.javalin.an.example;

import com.fasterxml.jackson.databind.ObjectMapper;
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
            ObjectMapper objectMapper = new ObjectMapper();

            context.result(objectMapper.writeValueAsString(get.getAllObject(Student.class)));
        });

        app.get("/student/:id", context -> {
            context.result("Hello from Get ListStudentById");

            Crud get = new Crud();
            ObjectMapper objectMapper = new ObjectMapper();

            context.result(objectMapper.writeValueAsString(get.getObject(Student.class , stringIdParam(context))));
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

            delete.deleteObject(Student.class, stringIdParam(context));
        });
    }


    public static void javalinGroupCommand(Javalin app){
        app.get("/groups", context -> {
            context.result("Hello from Get ListAllGroup");

            Crud get = new Crud();
            ObjectMapper objectMapper = new ObjectMapper();

            context.result(objectMapper.writeValueAsString(get.getAllObject(StudentGroup.class)));
        });

        app.get("/group/:id", context -> {
            context.result("Hello from Get ListGroupById");

            Crud get = new Crud();
            ObjectMapper objectMapper = new ObjectMapper();

            context.result(objectMapper.writeValueAsString(get.getObject(StudentGroup.class, stringIdParam(context))));
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

            delete.deleteObject(StudentGroup.class, stringIdParam(context));
        });
    }


    public static void javalinTutorCommand(Javalin app){
        app.get("/tutors", context -> {
            context.result("Hello from Get ListAllTutor");

            Crud get = new Crud();
            ObjectMapper objectMapper = new ObjectMapper();

            context.result(objectMapper.writeValueAsString(get.getAllObject(Tutor.class)));
        });

        app.get("/tutor/:id", context -> {
            context.result("Hello from Get ListTutorById");

            Crud get = new Crud();
            ObjectMapper objectMapper = new ObjectMapper();

            context.result(objectMapper.writeValueAsString(get.getObject(Tutor.class, stringIdParam(context))));
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

            delete.deleteObject(Tutor.class, stringIdParam(context));
        });
    }


    public static void javalinTutorStudentCommand(Javalin app){
        app.get("/tutorStudents", context -> {
            context.result("Hello from Get ListAllTutorStudent");

            Crud get = new Crud();
            ObjectMapper objectMapper = new ObjectMapper();

            context.result(objectMapper.writeValueAsString(get.getAllObject(TutorStudent.class)));
        });

        app.get("/tutorStudent/:id", context -> {
            context.result("Hello from Get ListTutorStudentById");

            Crud get = new Crud();
            ObjectMapper objectMapper = new ObjectMapper();

            context.result(objectMapper.writeValueAsString(get.getObject(TutorStudent.class, stringIdParam(context))));
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

            delete.deleteObject(TutorStudent.class, stringIdParam(context));
        });
    }


    public static int stringIdParam(Context context){
        return Integer.parseInt(context.pathParam("id"));
    }

    public static String scannerParam(Context context, int i){
        Scanner scanner = new Scanner(context.body());
        Stream<String> strings = scanner.tokens();
        String[] array = strings.toArray(String[]::new);
        System.out.println(array);
        String a = array[i];

        return a;

    }

}
