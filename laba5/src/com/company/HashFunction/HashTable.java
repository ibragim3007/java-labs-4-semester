package com.company.HashFunction;

import com.company.Person.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class HashTable<T1 extends Person,T2> {
    public List<T1>[] arrayList;
    public HashFunction<T2> HF;

    public HashTable(HashFunction<T2> hf){
        HF = hf;
        arrayList = new List[HF.size];
        for(int i = 0; i < arrayList.length; i++){
            arrayList[i] = new ArrayList<>();
        }
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "arrayList=" + Arrays.toString(arrayList) +
                '}';
    }

    protected abstract void addAtHT(T1 value);

}