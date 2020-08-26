package org.github.com.jefesimpson.javalin.an.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import org.github.com.jefesimpson.javalin.an.example.command.Crud;
import org.github.com.jefesimpson.javalin.an.example.tables.Student;

public class Tester {
    public static void main(String[] args) {
        Javalin app = Javalin.create();
        javalinGetAppExample(app);

        app.start(9999);
    }

    public static void javalinGetAppExample(Javalin app){
        Crud crud = new Crud();
        ObjectMapper objectMapper = new ObjectMapper();
        app.get("/students1", context -> {
            context.result(objectMapper.writeValueAsString(crud.getAllObject(Student.class)));
        });
    }

    public static void javalinPostAppExample(Javalin app){

    }
}
