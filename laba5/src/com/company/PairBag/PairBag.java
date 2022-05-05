package com.company.PairBag;

import com.company.Pair.Pair;
import com.company.bag.Bag;

public class PairBag {
    private final Bag pairThings;

    private final int maxSize;

    public PairBag(int maxSize) {
        this.pairThings = new Bag(maxSize);
        this.maxSize = maxSize;
    }

    public int getSize () { return  pairThings.getCurrentThingsQuantity(); }

    public void add (Pair<Object, Object> thing) {
        if (pairThings.getCurrentThingsQuantity() == maxSize) {
            System.out.println("Overflow");
            return;
        }
        pairThings.addThing(thing);
    }

    public Object removeOneThing () { return pairThings.pickThing(); }

    private int getRandomIndex(int max) {
        int min = 0;
        return  (int)(Math.random()*(max-min+1)+min);
    }

}
