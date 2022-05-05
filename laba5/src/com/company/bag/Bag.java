package com.company.bag;




public class Bag {
    private final int maxSize;
    private int currentThingsQuantity;
    private final Object[] things;

    private int getRandomIndex(int max) {
        int min = 0;
        return  (int)(Math.random()*(max-min+1)+min);
    }

    public Bag(int maxSize) {
        this.maxSize = maxSize;
        this.currentThingsQuantity = 0;
        this.things = new Object[maxSize];
    }

    public void addThing (Object value) {
        if (this.currentThingsQuantity == this.maxSize) {
            System.out.println("Overflow");
            return;
        }

        int index = getRandomIndex(this.currentThingsQuantity);
        for (int i = this.currentThingsQuantity; i > index; i--)
            this.things[i] = this.things[i - 1];

        this.things[index] = value;
        this.currentThingsQuantity++;
    }

    public Object pickThing () {

        if (currentThingsQuantity == 0) return -1;

        int index = getRandomIndex(this.currentThingsQuantity - 1);
        Object tempValue = this.things[index];

        for (int i = index; i < currentThingsQuantity - 1; i++)
            this.things[i] = this.things[i + 1];

        this.currentThingsQuantity--;

        return tempValue;
    }

    public void print () {
        System.out.print("[");

        for (int i = 0; i < currentThingsQuantity; i++) {
            System.out.print((String) String.valueOf(this.things[i]));
            if (i < currentThingsQuantity - 1) System.out.print(", ");
        }

        System.out.print("]");
    }

    public int getCurrentThingsQuantity() { return currentThingsQuantity; }
}
