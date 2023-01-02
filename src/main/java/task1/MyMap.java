package task1;

import java.util.Objects;

public class MyMap implements OwnMap {
    private final int CAPACITY = 16;
    private Node table[];

    public MyMap() {
        table = new Node[CAPACITY];
    }

    /**
    Jezeli do metody put dodac klucz ktory juz istnieje w mapie,
    to metoda zmieni tylko value i zwroci false, dopiero po dadaniu
    do metody klucza, ktorego jeszcze niema bedzie zwrocone true.
    */

    @Override
    public boolean put(String key, String value) {
        int index = index(key);
        Node current = table[index];

        if (current == null) {
            table[index] = new Node(key, value);
        } else {
            while (current.nextNode != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return false;
                }
                current = current.nextNode;
            }
            if (current.key.equals(key)) {
                current.value = value;
                return false;
            }
            current.nextNode = new Node(key, value);
        }
        return true;
    }

    @Override
    public String remove(String key) {
        int index = index(key);
        Node node = table[index];

        if (node == null) {
            return null;
        }
        Node prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev != null) {
                    prev.nextNode = node.nextNode;
                } else {
                    table[index] = node.nextNode;
                }
                return node.key;
            }
            prev = node;
            node = node.nextNode;
        }
        return null;
    }

    @Override
    public boolean containsKey(String key) {
        int index = index(key);
        Node node = table[index];

        if (node == null) {
            return false;
        }
        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.nextNode;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Node node : table) {
            Node current = node;
            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.nextNode;
            }
        }
        return false;
    }

    @Override
    public String get(String key) {
        int index = index(key);
        Node node = table[index];

        if (node == null) {
            return "null";
        }
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.nextNode;
        }
        return "key: " + key + " does not exist";
    }

    public String getKey(String key) {
        int index = index(key);
        Node node = table[index];

        if (node == null) {
            return "null";
        }
        while (node != null) {
            if (node.key.equals(key)) {
                return node.key;
            }
            node = node.nextNode;
        }
        return "key: " + key + " does not exist";
    }

    private class Node {
        private String key;
        private String value;
        private Node nextNode;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return Objects.equals(key, node.key) && Objects.equals(value, node.value);
        }
    }

    private int index(String key) {
        int i = key.hashCode();
        if (i < 0) {
            return Math.abs(i) % table.length;
        }
        return i % table.length;
    }
}
