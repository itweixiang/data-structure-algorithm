package com.itweixiang.study.hash;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(20);
        hashTable.add(new Emp(1,"aaa"));
        hashTable.add(new Emp(2,"bbb"));
        hashTable.add(new Emp(3,"ccc"));
        hashTable.add(new Emp(4,"ddd"));
        hashTable.print();
    }
}
