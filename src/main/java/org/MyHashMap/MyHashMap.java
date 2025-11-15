package org.MyHashMap;

import lombok.Data;

public class MyHashMap<K,V> {
    private static final int INITIAL_SIZE = 1 << 4; // 16
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    Entry[] hashTable;

    public MyHashMap() {
        hashTable = new Entry[INITIAL_SIZE];
    }

    public MyHashMap(int capacity) {
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }

    final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    @Data
    class Entry<K,V> {
        K key;
        V value;
        Entry next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key,V value) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        if(node == null) {
            Entry newNode = new Entry(key, value);
            hashTable[hashCode] = newNode;
        } else {
            Entry prev = node;
            while(node != null) {
                if(node.key == key) {
                    node.value = value;
                    return;
                }

                prev = node;
                node = node.next;
            }

            Entry newNode = new Entry(key, value);
            hashTable[hashCode] = newNode;
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        while(node != null) {
            if(node.key.equals(key)) {
                return (V) node.value;
            }

            node = node.next;
        }

        return null;
    }
}
