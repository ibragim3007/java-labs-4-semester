package com.company.Person;

import com.company.HashFunction.HashFunction;
import com.company.HashFunction.HashTable;

public class PersonHashTable extends HashTable<Person, String> {
    public PersonHashTable(HashFunction<String> hf) {
        super(hf);
    }

    public void addAtHT(Person value){
        arrayList[HF.hash(value.sname)].add(value);
    }
}
