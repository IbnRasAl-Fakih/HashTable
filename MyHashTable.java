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
            return  "{" + key + " = " + value + "}";
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
        return M;
    }

    public int numOfElements() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % M);
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> head = buckets[index];
        HashNode<K, V> temp = head;
        while (temp != null) {
            if (temp.key == key) {
                temp.value = value;
                return;
            }
            temp = temp.next;
        }
        size++;
        HashNode<K, V> node = new HashNode<>(key, value);
        node.next = head;
        buckets[index] = node;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> temp = buckets[index];
        while (temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> temp = buckets[index];
        HashNode<K, V> previousNode = null;
        while(temp != null) {
            if (temp.key == key) {
                if (previousNode == null) {
                    buckets[index] = temp.next;
                } else {
                    previousNode.next = temp.next;
                }
                size--;
                return temp.value;
            }
            previousNode = temp;
            temp = temp.next;
        }
        return null;
    }

    public boolean contains(V value) {
        for (int index = 0; index < size; index++) {
            HashNode<K, V> temp = buckets[index];
            while (temp != null) {
                if (temp.value == value) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int index = 0; index < size; index++) {
            HashNode<K, V> temp = buckets[index];
            while (temp != null) {
                if (temp.value == value) {
                    return temp.key;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public void print() {
        for (int index = 0; index < M; index++) {
            HashNode<K, V> temp = buckets[index];
            while (temp != null) {
                System.out.println(temp.toString());
                temp = temp.next;
            }
        }
    }

    public int countElements(int index) {
        int res = 0;
        HashNode<K, V> temp = buckets[index];
        while (temp != null) {
            res++;
            temp = temp.next;
        }
        return res;
    }

}
