package task4;

public class Pair<K, V> {
    K kay;
    V value;

    public Pair(K kay, V value) {
        this.kay = kay;
        this.value = value;
    }

    public K getKay() {
        return kay;
    }

    public V getValue() {
        return value;
    }
}
