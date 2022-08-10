package com.knubisoft.tasks.practical.ORM.Release10;

import com.knubisoft.Person;
import com.knubisoft.Person2;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream stream = Main.class.getClassLoader().getResourceAsStream("sample.csv");
        List<String> lines = IOUtils.readLines(stream, StandardCharsets.UTF_8);


        List<Person> personList = CSVOrm.transform(lines, Person.class);
        List<Person2> person2List = CSVOrm.transform(lines, Person2.class);
    }

}