public class MyHashTable<K, V> {

    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return '{' + (String)key + " " + (String)value + '}';
        }
    }

    private HashNode<K, V>[] buckets;
    private int M;
    private int size;

    public MyHashTable() {
        this(11);
    }

    public MyHashTable(int capacity) {
        this.M = capacity;
        this.buckets = new HashNode[M];
        this.size = 0;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
