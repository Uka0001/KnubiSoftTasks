package com.knubisoft.base.queue;

import com.knubisoft.base.queue.car.Car;
import com.knubisoft.base.queue.car.CarComparator;
import lombok.SneakyThrows;

import java.util.*;

public class QueueTasksImpl implements QueueTasks {

    @Override
    public Queue<Integer> reverseQueueUsingRecursion(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return queue;
        }
        int i = queue.poll();
        reverseQueueUsingRecursion(queue);
        queue.add(i);

        return queue;
    }

    @Override
    public Queue<Integer> reverseFirstKElementsOfQueue(Queue<Integer> queue, int k) {
        if (queue.isEmpty()) {
            return queue;
        }
        List<Integer> arr = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        while (k != 0) {
            arr.add(queue.poll());
            k--;
        }
        while (!queue.isEmpty()) {
            arr2.add(queue.poll());
        }
        while (arr.size() != 0) {
            queue.add(arr.get(arr.size() - 1));
            arr.remove(arr.size() - 1);
        }
        while (arr2.size() != 0) {
            queue.add(arr2.get(0));
            arr2.remove(0);
        }
        return queue;
    }

    @Override
    public Queue<Integer> sortQueueOfInt(Queue<Integer> queue) throws NullPointerException {
        int n = queue.size();
        for (int i = 0; i < n; i++) {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int currValue = queue.poll();

                if (currValue < minValue && j < (n - i)) {
                    minValue = currValue;
                    minIndex = j;
                }
                queue.add(currValue);
            }
            for (int j = 0; j < n; j++) {
                int currValue = queue.poll();
                if (j != minIndex) {
                    queue.add(currValue);
                }
            }
            queue.add(minValue);
        }
        return queue;
    }

    @Override
    public boolean validParentheses(String parentheses) {
        Map<Character,Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        for (char c : parentheses.toCharArray()){
            if (brackets.containsValue(c)){
                stack.push(c);
            }else if(brackets.containsKey(c)){
                if (stack.isEmpty() || stack.pop() != brackets.get(c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Override
    public PriorityQueue<Car> implementPriorityQueueThroughComparator(List<Car> cars) {
        PriorityQueue<Car> priorityQueue = new PriorityQueue<>(cars.size(), new CarComparator());
        priorityQueue.addAll(cars);
        return priorityQueue;
    }

}
