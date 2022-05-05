package com.company.GenericPairBag;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GenericPairBag<T1, T2>{
    protected Object[] bag;
    protected int size;
    protected Random rand = new Random();

    public GenericPairBag(int size){
        bag = new Object[size];
        this.size = size;
    }

    public void add(T1 first, T2 second){
        int pos = rand.nextInt(size);
        Map<T1,T2> dict = new HashMap<>();
        dict.put(first, second);
        bag[pos] = dict;
    }

    public Object del(){
        int pos = rand.nextInt(size);
        Object temp;
        if (bag[pos] != null){
            temp = bag[pos];
            bag[pos] = null;
        }
        else  temp = del();
        return temp;
    }

    public void print(){
        for (Object item : bag)
            System.out.println(item + " ");
    }


}
