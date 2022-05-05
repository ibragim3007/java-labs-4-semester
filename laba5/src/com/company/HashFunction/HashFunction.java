package com.company.HashFunction;

public abstract class HashFunction<T>{
    public int size;
    public HashFunction(int size){
        this.size = size;
    }

    public abstract int hash(T s);

}