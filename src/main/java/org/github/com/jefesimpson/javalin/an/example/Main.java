package org.github.com.jefesimpson.javalin.an.example;

import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create();
        Scanner sc = new Scanner(System.in);
        StudentCrudCommand studentCrudCommand = new StudentCrudCommand();
        StudentGroupCrudCommand studentGroupCrudCommand = new StudentGroupCrudCommand();

        app.get("/listAllStudent", context -> {
            context.result("Hello from Get ListAllStudent");
            context.result(studentCrudCommand.getStudent().toString());});
        app.get("/listStudent/:id", context -> {
            context.result("Hello from Get ListStudentById");
            context.result(studentCrudCommand.getStudentById(Integer.parseInt(fifthStringParam(context))).toString());});
        app.post("/create/:id/:firstName/:lastName/:groupId/:groupName", context -> {
            context.result("Hello from Post Create");
            studentCrudCommand.createStudent(new Student(Integer.parseInt(firstStringParam(context)),secondStringParam(context),thirdStringParam(context),new StudentGroup(Integer.parseInt(fourthStringParam(context)),fifthStringParam(context))));
            studentGroupCrudCommand.createStudentClass(new StudentGroup(Integer.parseInt(fourthStringParam(context)),fifthStringParam(context)));
        });
        app.patch("/update/:id/:firstName/:lastName/:groupId/:groupName", context -> {
            context.result("Hello from Patch Update");
            studentCrudCommand.updateStudent(new Student(Integer.parseInt(firstStringParam(context)),secondStringParam(context),thirdStringParam(context),new StudentGroup(Integer.parseInt(fourthStringParam(context)),fifthStringParam(context))));
            studentGroupCrudCommand.updateStudentClass(new StudentGroup(Integer.parseInt(fourthStringParam(context)),fifthStringParam(context)));
        });
        app.delete("/delete/:id/:firstName/:lastName/:groupId/:groupName", context -> {
            context.result("Hello from Delete Delete");
            studentCrudCommand.deleteStudent(new Student(Integer.parseInt(firstStringParam(context)),secondStringParam(context),thirdStringParam(context),new StudentGroup(Integer.parseInt(fourthStringParam(context)),fifthStringParam(context))));
            studentGroupCrudCommand.deleteStudentClass(new StudentGroup(Integer.parseInt(fourthStringParam(context)),fifthStringParam(context)));
        });

        app.start(9090);

    }

    public static String firstStringParam(Context context){
        String first = context.pathParam("id");
        return first;
    }

    public static String secondStringParam(Context context){
        String second = context.pathParam("firstName");
        return second;
    }

    public static String thirdStringParam(Context context){
        String third = context.pathParam("lastName");
        return third;
    }

    public static String fourthStringParam(Context context){
        String fourth = context.pathParam("groupId");
        return fourth;
    }

    public static String fifthStringParam(Context context){
        String fifth = context.pathParam("groupName");
        return fifth;
    }


}
