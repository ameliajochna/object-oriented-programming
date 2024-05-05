public class MyDictionary<K, V> {
    public MyDictionary<K, V> next;
    public K key;
    public V value;

    public MyDictionary() {
        key = null;
        value = null;
        next = null;
    }

    public void printDictionary() {
        MyDictionary<K, V> current = this;
        System.out.println("DICTIONARY CONTENT:");
        while (current != null) {
            System.out.println(current.key + " " + current.value);
            current = current.next;
        }
    }

    public boolean isKeyInDictionary(K findingKey) {
        MyDictionary<K, V> current = this;
        while (current != null) {
            if (current.key != null && current.key.equals(findingKey))
                return true;
            current = current.next;
        }
        return false;
    }

    public void add(K addingKey, V addingValue) {
        if (isKeyInDictionary(addingKey))
            throw new IllegalArgumentException("Key is already in the dictionary.");

        MyDictionary<K, V> current = this;
        while (current.next != null)
            current = current.next;

        current.next = new MyDictionary<>();
        current.next.key = addingKey;
        current.next.value = addingValue;
    }

    public V findValue(K findingKey) {
        MyDictionary<K, V> current = this;
        while (current != null) {
            if (current.key != null && current.key.equals(findingKey))
                return current.value;
            current = current.next;
        }

        throw new IllegalArgumentException("Key is not in the dictionary.");
    }

    public void removeKey(K removingKey) {
        if (key != null && key.equals(removingKey)) {
            this.key = next.key;
            this.value = next.value;
            this.next = next.next;
            return;
        }

        MyDictionary<K, V> current = this;
        MyDictionary<K, V> previous = null;
        while (current != null) {
            if (current.key != null && current.key.equals(removingKey)) {
                if (previous != null)
                    previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }

        throw new IllegalArgumentException("Key is not in the dictionary.");
    }
}