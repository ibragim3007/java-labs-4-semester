package com.company;

import com.company.Coins.Coins;
import com.company.DList.DList;
import com.company.GPairBag.GPairBag;
import com.company.GameTeam.GameTeam;
import com.company.Pair.Pair;
import com.company.PairBag.PairBag;
import com.company.bag.Bag;

public class Main {

    public static void main(String[] args) {
        Pair va1 = new Pair(2, "hello");
        Pair va2 = new Pair(3, "hello");
        Pair va3 = new Pair("32", "hello");
        Pair va4 = new Pair<>(5, "hello");

        PairBag paribag = new PairBag( 10);

        paribag.add(va1);
        paribag.add(va2);
        paribag.add(va3);
        paribag.add(va4);

        GPairBag testGbag = new GPairBag(10);

        testGbag.add(va1);
        testGbag.add(va3);

        testGbag.removeOneThing();


        String[] Teams = {"DreamTeam", "FlexTeam", "MerkaliTeam", "SomeBody"};
        GameTeam GamePlan = new GameTeam(Teams);

        DList<Integer, Integer> rofl = new DList<>();
        rofl.add(1, new Integer[]{1, 2});
        rofl.add(2, new Integer[]{5, 12, 51});

        rofl.print();

        System.out.print("\n\n");
        Coins cash = new Coins(1,4,7,9);
        cash.expand(10).print();

        System.out.print('\n');
        System.out.println(cash.getMin());

    }
}
