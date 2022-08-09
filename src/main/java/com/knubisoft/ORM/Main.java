package com.knubisoft.ORM;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.knubisoft.ORM.FileContentTypeEnum.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String inputFile = "sample.txt";
        switch (inputFile):{
            case (CSV):
                break;
            case (XML):
                break;
            case (JSON):
                InputStream stream = Main.class.getClassLoader().getResourceAsStream("sample.JSON");
                break;
            case (TXT):
                InputStream stream = Main.class.getClassLoader().getResourceAsStream(inputFile);
                break;
        }

        List<String> lines = IOUtils.readLines(stream, StandardCharsets.UTF_8);
        List<Person> personList = CsvORM.transform(lines);
    }
}
