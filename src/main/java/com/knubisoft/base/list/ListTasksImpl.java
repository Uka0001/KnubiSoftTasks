package com.knubisoft.base.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListTasksImpl implements ListTasks {
    @Override
    public List<String> addElements(String... elements) {
        List<String> newElements = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            newElements.add(elements[i]);
        }
        return newElements;
    }

    @Override
    public List<String> getElementsByIndexes(List<String> elements, int[] indexes) {
        try {
            for (int index : indexes) {
                elements.add(elements.get(index));
            }
            return elements;
        } catch (NullPointerException | IndexOutOfBoundsException e){
            throw new IllegalArgumentException("IllegalArgumentException");
        }
    }

    @Override
    public ArrayList<String> addElementsByIndexes(ArrayList<String> elements, int[] indexes) {
        try {
            for (int index : indexes) {
                elements.add(index, elements.get(index));
            }
            return elements;
        } catch (NullPointerException | IndexOutOfBoundsException e){
            throw new IllegalArgumentException("IllegalArgumentException");
        }
    }

    @Override
    public LinkedList<String> setElementsByIndexes(LinkedList<String> elements, int[] indexes) {
        try {
            for (int index : indexes) {
                elements.set(index, elements.get(index));
            }
            return elements;
        } catch (NullPointerException | IndexOutOfBoundsException e){
            throw new IllegalArgumentException("IllegalArgumentException");
        }
    }

    @Override
    public int getListSize(List<String> list) {
        if (list == null){
            return 0;
        } else if (list.isEmpty()){
            return 0;
        } else {
            return list.size();
        }
    }

    @Override
    public List<Long> merge(List<Integer> first, List<Long> second, List<String> third) {
        return null;
    }

    @Override
    public int findMaxValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        return -1;
    }

    @Override
    public int findMinValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        return -1;
    }

    @Override
    public int multiplyMax2Elements(List<Integer> first, List<Integer> second, List<Integer> third) {
        return -1;
    }

    @Override
    public List<String> removeNulls(List<String> list) {
        return null;
    }

    @Override
    public List<Integer> flatMapWithoutNulls(List<List<Integer>> list) {
        return null;
    }

    @Override
    public List<Integer> cloneIds(List<Integer> originalIds) {
        return null;
    }

    @Override
    public List<String> shuffle(List<String> originalStrings) {
        return null;
    }

    @Override
    public String getLastElement(LinkedList<String> list) {
        return null;
    }

    @Override
    public List<String> compareElements(LinkedList<String> originalCollection, LinkedList<String> additionalCollection) {
        return null;
    }
}
