package com.knubisoft.tasks.practical.ORM.Release11;

import com.knubisoft.tasks.practical.ORM.Release11.ORM;
import com.knubisoft.tasks.practical.ORM.Release11.Person2;

import java.io.File;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        URL url = Main.class.getClassLoader().getResource("sample.json");
        List<Person2> result = new ORM().transform(new File(url.toURI()), Person2.class);
    }
}