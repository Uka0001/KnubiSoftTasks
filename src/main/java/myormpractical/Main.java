package myormpractical;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static final String DELIMITER = ",";

    public static void main(String[] args) throws IOException, NullPointerException {
//        File file = new File("src/main/resources/sample.csv");
//        List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
        InputStream stream = Main.class.getClassLoader().getResourceAsStream("sample.csv");
        List<String> lines = IOUtils.readLines(stream, StandardCharsets.UTF_8);

        //LineIterator itr = FileUtils.lineIterator();
        List<Person> personList = transform(lines.subList(1, lines.size()));
    }

    private static List<Person> transform(List<String> lines) {
        return lines.stream().map(Main::toPerson).collect(Collectors.toList());
    }

    private static Person toPerson(String line) {
        String [] array = line.split(DELIMITER);
        return new Person(
                array[0],
                Integer.parseInt(array[1]),
                Float.parseFloat(array[2]),
                array[3],
                LocalDate.parse(array[4])
        );
    }
}
