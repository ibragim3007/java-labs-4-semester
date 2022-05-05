package com.company.Person;

import com.company.HashFunction.HashFunction;

public class PersonHashFunction extends HashFunction<String> {
    public PersonHashFunction(int size) {
        super(size);
    }

    @Override
    public int hash(String s){
        long p =  (s.charAt(0) - 'A' + 1);
        for (int i = 1;i < s.length(); i++){
            p= p * 37 + (s.charAt(i) - 'A' + 1);
        }
        System.out.println(p % size);
        return (int) (p % size);
    }
}