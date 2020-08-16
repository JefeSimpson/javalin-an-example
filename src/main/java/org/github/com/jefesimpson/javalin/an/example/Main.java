package org.github.com.jefesimpson.javalin.an.example;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.github.com.jefesimpson.javalin.an.example.group.StudentGroup;
import org.github.com.jefesimpson.javalin.an.example.group.StudentGroupCrudCommand;
import org.github.com.jefesimpson.javalin.an.example.student.Student;
import org.github.com.jefesimpson.javalin.an.example.student.StudentCrudCommand;
import org.github.com.jefesimpson.javalin.an.example.tutor.Tutor;
import org.github.com.jefesimpson.javalin.an.example.tutor.TutorCrudCommand;
import org.github.com.jefesimpson.javalin.an.example.tutorstudent.TutorStudent;
import org.github.com.jefesimpson.javalin.an.example.tutorstudent.TutorStudentCrudCommand;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        javalinCommand(Javalin.create());
    }

    public static void javalinCommand(Javalin app){
        javalinStudentCommand(app);
        javalinGroupCommand(app);
        javalinTutorCommand(app);
        javalinTutorStudentCommand(app);
        app.start(9090);
    }


    public static void javalinStudentCommand(Javalin app){
        app.get("/students", context -> {
            context.result("Hello from Get ListAllStudent");

            StudentCrudCommand get = new StudentCrudCommand();

            context.result(get.getStudent().toString());
        });

        app.get("/student/:id", context -> {
            context.result("Hello from Get ListStudentById");

            StudentCrudCommand get = new StudentCrudCommand();

            context.result(get.getStudentById(Integer.parseInt(stringParam(context,0))).toString());
        });

        app.post("/student/:id/:firstName/:lastName/:groupId", context -> {
            context.result("Hello from Post Create");

            StudentCrudCommand post = new StudentCrudCommand();
            StudentGroupCrudCommand poster = new StudentGroupCrudCommand();

            StudentGroup studentGroup = poster.getStudentGroupById(Integer.parseInt(stringParam(context, 3)));

            post.postStudent(new Student(Integer.parseInt(stringParam(context, 0)),stringParam(context, 1),stringParam(context, 2), studentGroup));
        });

        app.patch("/student/:id/:firstName/:lastName/:groupId", context -> {
            context.result("Hello from Patch Update");

            StudentCrudCommand patch = new StudentCrudCommand();
            StudentGroupCrudCommand patcher = new StudentGroupCrudCommand();

            StudentGroup studentGroup = patcher.getStudentGroupById(Integer.parseInt(stringParam(context,3)));

            patch.patchStudent(new Student(Integer.parseInt(stringParam(context, 0)),stringParam(context, 1),stringParam(context, 2), studentGroup));
        });

        app.delete("/student/:id", context -> {
            context.result("Hello from Delete Delete");

            StudentCrudCommand delete = new StudentCrudCommand();

            delete.deleteStudent(Integer.parseInt(stringParam(context, 0)));
        });
    }


    public static void javalinGroupCommand(Javalin app){
        app.get("/groups", context -> {
            context.result("Hello from Get ListAllGroup");

            StudentGroupCrudCommand get = new StudentGroupCrudCommand();

            context.result(get.getStudentGroup().toString());
        });

        app.get("/group/:id", context -> {
            context.result("Hello from Get ListGroupById");

            StudentGroupCrudCommand get = new StudentGroupCrudCommand();

            context.result(get.getStudentGroupById(Integer.parseInt(stringParam(context,0))).toString());
        });

        app.post("/group/:id/:groupName", context -> {
            context.result("Hello from Post Create");

            StudentGroupCrudCommand post = new StudentGroupCrudCommand();

            post.postStudentGroup(new StudentGroup(Integer.parseInt(stringParam(context,0)), stringParam(context,1)));
        });

        app.patch("/group/:id/:groupName", context -> {
            context.result("Hello from Patch Update");

            StudentGroupCrudCommand patch = new StudentGroupCrudCommand();

            patch.patchStudentGroup(new StudentGroup(Integer.parseInt(stringParam(context,0)), stringParam(context,1)));
        });

        app.delete("/group/:id", context -> {
            context.result("Hello from Delete Delete");

            StudentGroupCrudCommand delete = new StudentGroupCrudCommand();

            delete.deleteStudentGroup(Integer.parseInt(stringParam(context, 0)));
        });
    }


    public static void javalinTutorCommand(Javalin app){
        app.get("/tutors", context -> {
            context.result("Hello from Get ListAllTutor");

            TutorCrudCommand get = new TutorCrudCommand();

            context.result(get.getTutor().toString());
        });

        app.get("/tutor/:id", context -> {
            context.result("Hello from Get ListTutorById");

            TutorCrudCommand get = new TutorCrudCommand();

            context.result(get.getTutorById(Integer.parseInt(stringParam(context,0))).toString());
        });

        app.post("/tutor/:id/:firstName/:lastName/:groupId", context -> {
            context.result("Hello from Post Create");

            TutorCrudCommand post = new TutorCrudCommand();
            StudentGroupCrudCommand poster = new StudentGroupCrudCommand();

            StudentGroup studentGroup = poster.getStudentGroupById(Integer.parseInt(stringParam(context, 3)));

            post.postTutor(new Tutor(Integer.parseInt(stringParam(context, 0)),stringParam(context, 1),stringParam(context, 2), studentGroup));
        });

        app.patch("/tutor/:id/:firstName/:lastName/:groupId", context -> {
            context.result("Hello from Patch Update");

            TutorCrudCommand patch = new TutorCrudCommand();
            StudentGroupCrudCommand patcher = new StudentGroupCrudCommand();

            StudentGroup studentGroup = patcher.getStudentGroupById(Integer.parseInt(stringParam(context,3)));

            patch.patchTutor(new Tutor(Integer.parseInt(stringParam(context, 0)),stringParam(context, 1),stringParam(context, 2), studentGroup));
        });

        app.delete("/tutor/:id", context -> {
            context.result("Hello from Delete Delete");

            TutorCrudCommand delete = new TutorCrudCommand();

            delete.deleteTutor(Integer.parseInt(stringParam(context, 0)));
        });
    }


    public static void javalinTutorStudentCommand(Javalin app){
        app.get("/tutorStudents", context -> {
            context.result("Hello from Get ListAllTutorStudent");

            TutorStudentCrudCommand get = new TutorStudentCrudCommand();

            context.result(get.getTutorStudent().toString());
        });

        app.get("/tutorStudent/:id", context -> {
            context.result("Hello from Get ListTutorStudentById");

            TutorStudentCrudCommand get = new TutorStudentCrudCommand();

            context.result(get.getTutorStudentById(Integer.parseInt(stringParam(context,0))).toString());
        });

        app.post("/tutorStudent/:id/:studentId/:tutorId", context -> {
            context.result("Hello from Post Create");

            TutorStudentCrudCommand post = new TutorStudentCrudCommand();
            StudentCrudCommand poster = new StudentCrudCommand();
            TutorCrudCommand toaster = new TutorCrudCommand();

            Student student = poster.getStudentById(Integer.parseInt(stringParam(context, 1)));
            Tutor tutor = toaster.getTutorById(Integer.parseInt(stringParam(context,2)));

            post.postTutorStudent(new TutorStudent(Integer.parseInt(stringParam(context,0)), student, tutor));
        });

        app.patch("/tutorStudent/:id/:studentId/:tutorId", context -> {
            context.result("Hello from Patch Update");

            TutorStudentCrudCommand patch = new TutorStudentCrudCommand();
            StudentCrudCommand patcher = new StudentCrudCommand();
            TutorCrudCommand toaster = new TutorCrudCommand();

            Student student = patcher.getStudentById(Integer.parseInt(stringParam(context, 1)));
            Tutor tutor = toaster.getTutorById(Integer.parseInt(stringParam(context,2)));

            patch.patchTutorStudent(new TutorStudent(Integer.parseInt(stringParam(context,0)), student, tutor));
        });

        app.delete("/tutorStudent/:id", context -> {
            context.result("Hello from Delete Delete");

            TutorStudentCrudCommand delete = new TutorStudentCrudCommand();

            delete.deleteTutorStudent(Integer.parseInt(stringParam(context, 0)));
        });
    }


    public static String stringParam(Context context, int i){
        Collection<String> strings = context.pathParamMap().values();
        String[] array = strings.toArray(String[]::new);
        return array[i];
    }


}
