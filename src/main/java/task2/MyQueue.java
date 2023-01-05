package task2;

import java.util.NoSuchElementException;

public class MyQueue implements OwnQueue {
    private Integer[] queue;
    private int front;
    private int rear;
    private int size;

    public MyQueue(int capacity) {
        this.queue = new Integer[capacity];
        this.front = -1;
        this.rear = -1;
    }

    public MyQueue() {
        this.queue = new Integer[10];
    }

    @Override
    public boolean add(Integer value) {
        if (size == queue.length) {
            Integer[] list = new Integer[queue.length * 2];
            for (int i = 0; i < queue.length; i++) {
                list[i] = queue[i];
            }
            queue = list;
        }
        if (front == -1 && rear == -1) {
            front = rear = 0;
            queue[rear] = value;
            size++;
        } else {
            queue[rear] = value;
            rear++;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public Integer remove() {
        if (queue[front] == null) {
            throw new NoSuchElementException("queue is empty");
        }
        int value = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
            size--;
        }
        return value;
    }

    @Override
    public Integer element() {
        return queue[front];
    }

    public void printQueue() {
        for (int i = front; i < rear; i++) {
            System.out.print(queue[i] + ", ");
        }
    }
}
