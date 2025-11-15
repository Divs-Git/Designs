package org.MyHashMap;

public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();
        map.put(12, 3);
        map.put(3, 45);
        map.put(4, 43);
        System.out.println(map.get(11));
    }
}
