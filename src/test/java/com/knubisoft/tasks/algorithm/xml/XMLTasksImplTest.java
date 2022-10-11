package com.knubisoft.tasks.algorithm.xml;

import com.knubisoft.tasks.algorithm.ModelRoot;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XMLTasksImplTest {

    private final XMLTasks object = new XMLTasksImpl();
    private final String content;

    public XMLTasksImplTest() throws IOException {
        content = FileUtils.readFileToString(new File("src/main/resources/xml.xml"), StandardCharsets.UTF_8);
    }

    @Test
    void parseXML() {
        ModelRoot result = object.parseXML(content);

        assertEquals(3, result.items.size());
        /*
            TODO add extra checks
         */
    }

    @Test
    void getAllIds() {
        List<Integer> result = object.getAllIds(content);

        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    void getNameWithIdMoreThan1() {
        List<String> result = object.getNameWithIdMoreThan1(content);
        assertEquals(Arrays.asList("Cake2", "Cake3"), result);
    }
}