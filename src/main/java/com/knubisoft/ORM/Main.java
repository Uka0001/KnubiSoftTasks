package com.knubisoft.ORM;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.activation.MimeType;
import org.apache.tika.Tika;

public class Main {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("sample.txt");
        String type = new Tika().detect(inputFile);
        System.out.println(type);
        InputStream stream = Main.class.getClassLoader().getResourceAsStream("sample.txt");
        List<String> lines = IOUtils.readLines(stream, StandardCharsets.UTF_8);
        List<Person> personList = CsvORM.transform(lines);
    }
}
