package com.knubisoft.tasks.algorithm.json;

import com.knubisoft.tasks.algorithm.ModelRoot;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JsonTasksImplTest {

    private final JsonTasks object = new JsonTasksImpl();
    private final String content;

    public JsonTasksImplTest() throws IOException {
        content = FileUtils.readFileToString(new File("src/main/resources/json.json"), StandardCharsets.UTF_8);
    }

    @Test
    void parseJson() {
        ModelRoot result = object.parseJson(content);
        InputStream wrongPath = ModelRoot.class.getClassLoader().getResourceAsStream("js.s");

        assertEquals(3, result.items.size());

        assertEquals(result.getItems().get(0), result.getItems().get(0));

        assertEquals("Cake3:3", result.getItems().get(2).name + ":" + result.getItems().get(2).id);

        assertThrows(IndexOutOfBoundsException.class, () -> result.items.get(result.getItems().size() + 1));
        assertThrows(NullPointerException.class, () -> object.parseJson(wrongPath.toString()));

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

    @Test
    @SneakyThrows
    void getAllItems() {
        List<Map<String, String>> result = object.getAllItems(content);
        String wrongFile = FileUtils.readFileToString(new File("src/main/resources/test.json"), StandardCharsets.UTF_8);

        assertEquals(3, result.size());

        assertThrows(NullPointerException.class, () -> object.getAllItems(null));
        assertThrows(NullPointerException.class, () -> object.getAllItems(wrongFile));
    }
}