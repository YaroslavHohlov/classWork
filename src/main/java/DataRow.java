public class DataRow<K, V> {
    private final K key;
    private final V value;

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public DataRow(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "[" + this.key + ", " + this.value + "]";
    }
}
