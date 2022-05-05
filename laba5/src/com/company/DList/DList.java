package com.company.DList;

import com.company.Pair.Pair;

import java.util.ArrayList;
import java.util.Collections;

public class DList<T1, T2> {
    private ArrayList<T1> list;
    private ArrayList<ArrayList<T2>> listOfLists;
    private int length;

    public DList() {
        this.list = new ArrayList<>();
        this.listOfLists = new ArrayList<>();
    }

    public void add(T1 value, T2[] values) {
        this.list.add(value);
        ArrayList<T2> dl = new ArrayList<>();
        Collections.addAll(dl, values);
        this.listOfLists.add(dl);

        this.length++;
    }

    public void remove(int position) {
        this.list.remove(position);
        this.listOfLists.remove(position);

        this.length--;
    }

    public Pair<T1, ArrayList<T2>> get(int position) {
        return new Pair<>(this.list.get(position), this.listOfLists.get(position));
    }

    public void print() {
        System.out.print(list);
        System.out.print('\n');
        System.out.print(listOfLists);
    }

}

