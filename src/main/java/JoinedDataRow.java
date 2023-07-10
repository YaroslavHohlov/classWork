public class JoinedDataRow<K, V1, V2> {
    private final K key;
    private final V1 value1;
    private final V2 value2;

    public K getKey() {
        return key;
    }

    public V1 geV1() {
        return value1;
    }

    public V2 getV2() {
        return value2;
    }

    public JoinedDataRow(K key, V1 value1, V2 value2) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "[" + this.key + ", " + this.value1 + ", " + this.value2 + "]";
    }
}
