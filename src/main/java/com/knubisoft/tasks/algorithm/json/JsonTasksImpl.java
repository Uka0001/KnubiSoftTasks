package com.knubisoft.tasks.algorithm.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knubisoft.tasks.algorithm.ModelRoot;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonTasksImpl implements JsonTasks {

    @Override
    @SneakyThrows
    public ModelRoot parseJson(String json) {
        if (json == null || json.isEmpty()) {
            throw new IllegalArgumentException();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        return objectMapper.readValue(json, ModelRoot.class);
    }

    @Override
    @SneakyThrows
    public List<Integer> getAllIds(String json) {
        if (json == null || json.isEmpty()) {
            throw new IllegalArgumentException();
        }
        List<Integer> list = new ArrayList<>();
        ObjectMapper oobjectMapper = new ObjectMapper();

        oobjectMapper.findAndRegisterModules();

        ModelRoot modelRoot = oobjectMapper.readValue(json, ModelRoot.class);

        for (ModelRoot.Item i : modelRoot.getItems()) {
            list.add(i.id);
        }

        return list;
    }

    @Override
    @SneakyThrows
    public List<String> getNameWithIdMoreThan1(String json) {
        if (json == null || json.isEmpty()) {
            throw new IllegalArgumentException();
        }
        List<String> list = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        ModelRoot modelRoot = objectMapper.readValue(json, ModelRoot.class);

        for (ModelRoot.Item item : modelRoot.getItems()) {
            if (item.id > 1) {
                list.add(item.name);
            }
        }

        return list;
    }

    @Override
    @SneakyThrows
    public List<Map<String, String>> getAllItems(String json) {

        if (json == null || json.isEmpty()) {
            throw new NullPointerException();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        ModelRoot modelRoot = objectMapper.readValue(json, ModelRoot.class);
        List<ModelRoot.Item> items = modelRoot.getItems();
        return items.stream().map(item -> Map.of(item.getName(), item.toString())).collect(Collectors.toList());
    }

}
