package com.knubisoft.ORM;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream stream = Main.class.getClassLoader().getResourceAsStream("sample.txt");
        List<String> lines = IOUtils.readLines(stream, StandardCharsets.UTF_8);
        List<Person> personList = CsvORM.transform(lines);
    }
}
