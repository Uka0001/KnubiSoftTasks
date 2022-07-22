package com.knubisoft.base.list;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        /*Stream<Integer> list1 = first.stream();
        Stream<Long> list2 = second.stream();
        List<Integer> list3Int = third.stream()
                    .map(Integer::parseInt).toList();
        Stream<Integer> streamInt = list3Int.stream();
        Stream<Long> list= (Stream<Long>) Stream.concat(list1, list2, streamInt);
        return list.collect(Collectors.toList());*/

        /*List<Integer> listIntegers = new ArrayList<Integer>(third.size());
        for(String current:third){
            listIntegers.add(Integer.parseInt(current));
        }
        Stream<Integer> list1 = first.stream();
        Stream<Long> list2 = second.stream();
        Stream<Long> list= (Stream<Long>) Stream.concat(list1, list2, listIntegers);
        return list.collect(Collectors.toList());*/

       /* first.stream()
                .map(Long::valueOf)
                .collect(Collectors.toList());
        third.stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());
        Stream<Long> list= (Stream<Long>) Stream.concat(first.stream(), second.stream(), third.stream());
*/
        /*List<Long>list1= (List<Long>) Arrays.asList(first.stream().flatMapToLong());
        List<Long>list2= (List<Long>) Arrays.asList(second);
        List<Long>list3= (List<Long>) Arrays.asList(third);
        List<Long> newList = Stream.of(list1, list2, list3)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return newList;*/

        /*Stream<Integer> list1 = first.stream();
        Stream<Long> list2 = second.stream();
        Stream<String> list3 = third.stream();
        first.stream()
                .map(Long::valueOf)
                .collect(Collectors.toList());
        third.stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());
        List<Long> newList = Stream.of(list1, list2, list3)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return newList;*/
        return second;
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
